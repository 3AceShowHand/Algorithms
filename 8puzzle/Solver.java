import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import java.util.ArrayList;

/**
 * Author:     Christopher
 * Written:    2017/5/14
 */

public class Solver {

    // record all board have been tracked.
    private ArrayList<Board> records;
    private boolean solvable;
    private Stack<Board> trace;
    private SearchNode lastNode;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new NullPointerException();
        }

        records = new ArrayList<>();
        trace = new Stack<>();
        solvable = true;

        SearchNode initialNode = new SearchNode(initial, 0, initial.manhattan(), null, false);
        Board twin = initial.twin();
        SearchNode twinNode = new SearchNode(twin, 0, twin.manhattan(), null, true);
        MinPQ<SearchNode> pq = new MinPQ<>();
        pq.insert(initialNode);
        pq.insert(twinNode);

        SearchNode currentNode;
        while (!pq.isEmpty()) {
            currentNode = pq.delMin();
            records.add(currentNode.board);
            if (currentNode.board.isGoal()) {
                if (currentNode.isTwin) {
                    solvable = false;
                } else {
                    lastNode = currentNode;
                    while (lastNode.previous != null) {
                        trace.push(lastNode.board);
                        lastNode = lastNode.previous;
                    }
                    trace.push(initial);
                }
                break;
            } else {
                Iterable<Board> neighbors = currentNode.board.neighbors();
                for (Board b: neighbors) {
                    if (currentNode.previous == null || !currentNode.previous.board.equals(b)) {
                        pq.insert(new SearchNode(b, 1 + currentNode.move, b.manhattan(), currentNode, currentNode.isTwin));
                    }
                }
            }
        }

    }

    // is the initial board solvable?
    public boolean isSolvable() {
        return solvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) {
            return -1;
        } else {
            return trace.size() - 1;
        }
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable()) {
            return null;
        } else {
            return trace;
        }
    }

    private class SearchNode implements Comparable<SearchNode> {

        private Board board;
        private int move;
        private int priority;
        private SearchNode previous;
        private boolean isTwin;

        private SearchNode(Board b, int move, int priority, SearchNode pre, boolean isTwin) {
            this.board = b;
            this.move = move;
            this.priority = this.move + priority;
            this.previous = pre;
            this.isTwin = isTwin;
        }

        public int compareTo(SearchNode other) {
            if (this.priority > other.priority) {
                return 1;
            } else if (this.priority == other.priority) {
                return 0;
            } else {
                return -1;
            }
        }

    }
}

import edu.princeton.cs.algs4.MinPQ;
import java.util.ArrayList;

/**
 * Author:     Christopher
 * Written:    2017/5/14
 */

public class Solver {

    private int initialMove;
    // sol is used to save all boards to find the goal
    private ArrayList<Board> sol;
    private boolean solvable;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new NullPointerException();
        }

        sol = new ArrayList<>();

        solvable = true;
        initialMove = 0;
        int twinMove = 0;
        Board initialTwin = initial.twin();
        SearchNode initialNode = new SearchNode(initial, initialMove + initial.manhattan(), null, false);
        SearchNode initialTwinNode = new SearchNode(initialTwin, twinMove + initialTwin.manhattan(), null, true);

        MinPQ<SearchNode> pq = new MinPQ<>();
        pq.insert(initialNode);
        pq.insert(initialTwinNode);

        SearchNode current;
        while (!pq.isEmpty()) {
            current = pq.delMin();
            if (current.board.isGoal()) {
                if (current.isTwin) {
                    solvable = false;
                } else {
                    sol.add(current.board);
                }
                break;
            } else {
                if (!current.isTwin) {
                    initialMove += 1;
                    sol.add(current.board);
                    Iterable<Board> neighbors = current.board.neighbors();
                    for (Board b: neighbors) {
                        if (current.previous == null || !current.previous.board.equals(b)) {
                            pq.insert(new SearchNode(b, initialMove + b.manhattan(), current, current.isTwin));
                        }
                    }
                } else {
                    twinMove += 1;
                    Iterable<Board> neighbors = current.board.neighbors();
                    for (Board b: neighbors) {
                        if (current.previous == null || !current.previous.board.equals(b)) {
                            pq.insert(new SearchNode(b, twinMove + b.manhattan(), current, current.isTwin));
                        }
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
            return initialMove;
        }
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable()) {
            return null;
        } else {
            return sol;
        }
    }

    private class SearchNode implements Comparable<SearchNode> {

        private Board board;
        private int priority;
        private SearchNode previous;
        private boolean isTwin;

        private SearchNode(Board b, int priority, SearchNode pre, boolean isTwin) {
            this.board = b;
            this.priority = priority;
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

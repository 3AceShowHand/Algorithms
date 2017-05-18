import edu.princeton.cs.algs4.MinPQ;
import java.util.ArrayList;

/**
 * Author:     Christopher
 * Written:    2017/5/14
 */

public class Solver {

    private int currentMove;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new NullPointerException();
        }
        currentMove = 0;
        SearchNode initialNode = new SearchNode(initial, initial.manhattan(), null);

        MinPQ<SearchNode> pq = new MinPQ<>();
        pq.insert(initialNode);

        ArrayList<Board> trace = new ArrayList<>();
        trace.add(initial);

        ArrayList<SearchNode> records = new ArrayList<>();
        records.add(initialNode);
    }

    // is the initial board solvable?
    public boolean isSolvable() {
        return false;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) {
            return -1;
        } else {
            return currentMove;
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
        private int priority;
        private SearchNode previous;

        private SearchNode(Board b, int priority, SearchNode pre) {
            this.board = b;
            this.priority = priority;
            this.previous = pre;
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

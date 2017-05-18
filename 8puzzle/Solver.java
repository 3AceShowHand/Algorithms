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
        MinPQ<SearchNode> pq = new MinPQ<>();
        SearchNode initialNode = new SearchNode(initial, initial.manhattan(), null);
        pq.insert(initialNode);
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

        }
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable()) {
            return null;
        } else {
            ArrayList<Board> sol = new ArrayList<>();
        }
    }

    private class SearchNode {

        private Board board;
        private int priority;
        private SearchNode previous;

        private SearchNode(Board b, int priority, SearchNode pre) {
            this.board = b;
            this.priority = priority;
            this.previous = pre;
        }
    }

}

/**
 * Author:     Christopher
 * Written:    2017/5/14
 */
public class Solver {

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new NullPointerException();
        }
    }

    // is the initial board solvable?
    public boolean isSolvable() {
        return false;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        return 0;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        return null;
    }

    private class SearchNode {
        Board board;
        int priority;
        int numOfMove;
        SearchNode previous;

        private SearchNode(Board b, int priority, int move, SearchNode pre) {
            this.board = b;
            this.priority = priority;
            this.numOfMove = move;
            this.previous = pre;
        }
    }

}

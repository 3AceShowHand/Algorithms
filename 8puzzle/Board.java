/**
 * Author:     Christopher
 * Written:    2017/5/14
 */
public class Board {

    // construct a board from an n-by-n array of blocks
    public Board(int[][] blocks) {

    }

    public int dimension() {
        return 0;
    }

    // number of blocks out of place
    public int hamming() {
        return 0;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        return 0;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return false;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        return null;
    }


    public boolean equals(Object y) {
        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return null;
    }

    public String toString() {
        return null;
    }

}

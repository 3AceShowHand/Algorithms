/**
 * Author:     Christopher
 * Written:    2017/5/14
 */
public class Board {

    private int[][] grid;
    // construct a board from an n-by-n array of blocks
    public Board(int[][] blocks) {
        grid = blocks;
    }

    // return the number at grid[i][j]
    private int tileAt(int i, int j) {
        return grid[i][j];
    }

    // board dimension n
    public int dimension() {
        return grid.length;
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
        StringBuilder s = new StringBuilder();
        int N = dimension();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i, j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
    }

}

import java.util.Arrays;
import edu.princeton.cs.algs4.Queue;

/**
 * Author:     Christopher
 * Written:    2017/5/14
 */

public class Board {

    private int[][] grid;
    private int size;

    // construct a board from an n-by-n array of blocks
    public Board(int[][] blocks) {
        grid = Arrays.copyOf(blocks, blocks.length);
        size = grid.length;
    }

    // return the number at grid[i][j]
    private int tileAt(int i, int j) {
        return grid[i][j];
    }

    private int xyTo1D(int i, int j) {
        return i * size + j + 1;
    }

    private int getRow(int idx) {
        return (idx-1) / size;
    }

    private int getCol(int idx) {
        return (idx-1) % size;
    }

    // board dimension n
    public int dimension() {
        return size;
    }

    // number of blocks in the wrong pisition,
    // plus the number of moves made so far to get to the search node.
    public int hamming() {
        int hammingCode = 0;
        int maxNumber = size * size - 1;
        for (int i = 1; i <= maxNumber; i++) {
            if (i != tileAt(getRow(i), getCol(i))) {
                hammingCode += 1;
            }
        }
        return hammingCode;
    }

    // Sum of the Manhattan distances from the blocks to their goal positions,
    // plus the number of moves made so far to get to the search node.
    public int manhattan() {
        int distance = 0;
        int N = size;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = tileAt(i, j);
                if (value != 0) {
                    int actualAtX = getRow(value);
                    int actualAtY = getCol(value);
                    distance += Math.abs(i - actualAtX) + Math.abs(j - actualAtY);
                }
            }
        }
        return distance;
    }

    // is this board the goal board?
    public boolean isGoal() {
        int N = size;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tileAt(i,j) != xyTo1D(i,j) && j != size-1) {
                    return false;
                }
            }
        }
        return true;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        return null;
    }


    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board that = (Board) y;
        return (this.grid.equals(that.grid)) && (this.dimension() == that.dimension());
    }

    // all neighboring boards of certain search node, without happened twice.
    public Iterable<Board> neighbors() {
        Queue<Board> neighbors = new Queue<>();

        return neighbors;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size;
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

        StdOut.println(initial);
        StdOut.println(initial.hamming());
        StdOut.println(initial.manhattan());
    }
}

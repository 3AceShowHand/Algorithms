import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Author:     Christopher
 * Written:    2017/5/14
 */

public class Board {

    private int[][] grid;
    private int size;

    // construct a board from an n-by-n array of blocks
    public Board(int[][] blocks) {
        if (blocks == null) {
            throw new NullPointerException();
        }
        grid = Arrays.copyOf(blocks, blocks.length);
        size = grid.length;
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
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if (tileAt(i,j) != xyTo1D(i,j) && j != size - 1) {
//                    return false;
//                }
//            }
//        }
//        return true;
        return 0 == manhattan();
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        int[][] tiles = deepCopyOf(grid);
        Board twin = new Board(tiles);
        int len = size * size;
        int i = StdRandom.uniform(1, len);
        int j = StdRandom.uniform(1, len);


        while (!isBlock(getRow(i), getCol(i))) {
            i = StdRandom.uniform(1, len);
        }
        while (j == i || !isBlock(getRow(j), getCol(j))) {
            j = StdRandom.uniform(1, len);
        }

        swap(twin, i, j);
        return twin;
    }

    public boolean equals(Object y) {
        if (y == this) {
            return true;
        }
        if (y == null) {
            return false;
        }
        if (y.getClass() != this.getClass()) {
            return false;
        }
        Board that = (Board) y;
        return (this.grid.equals(that.grid)) && (this.dimension() == that.dimension());
    }

    // all neighboring boards of certain search node, without the same as privous board
    public Iterable<Board> neighbors() {
        ArrayList<Board> neighbors = new ArrayList<>();
        int blankPos = findPositionOf(0);
        int blankRow = getRow(blankPos);
        int blankCol = getCol(blankPos);

        if (isValid(blankRow - 1, blankCol)) {
            int[][] tiles = deepCopyOf(grid);
            Board up = new Board(tiles);
            swap(up, xyTo1D(blankRow - 1, blankCol), blankPos);
            neighbors.add(up);
        }
        if (isValid(blankRow + 1, blankCol)) {
            int[][] tiles = deepCopyOf(grid);
            Board down = new Board(tiles);
            swap(down, xyTo1D(blankRow + 1, blankCol), blankPos);
            neighbors.add(down);
        }
        if (isValid(blankRow, blankCol - 1)) {
            int[][] tiles = deepCopyOf(grid);
            Board left = new Board(tiles);
            swap(left, xyTo1D(blankRow, blankCol - 1), blankPos);
            neighbors.add(left);
        }
        if (isValid(blankRow, blankCol + 1)) {
            int[][] tiles = deepCopyOf(grid);
            Board right = new Board(tiles);
            swap(right, xyTo1D(blankRow, blankCol + 1), blankPos);
            neighbors.add(right);
        }
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

    private static int[][] deepCopyOf(int[][] tiles) {
        int[][] res = new int[tiles.length][];
        for (int i = 0; i < tiles.length; i++) {
            res[i] = Arrays.copyOf(tiles[i], tiles[i].length);
        }
        return res;
    }

    // return the number at grid[i][j]
    private int tileAt(int i, int j) {
        return grid[i][j];
    }

    // Convert 2d index to 1d
    private int xyTo1D(int i, int j) {
        return i * size + j + 1;
    }

    private int getRow(int idx) {
        return (idx - 1) / size;
    }

    private int getCol(int idx) {
        return (idx - 1) % size;
    }

    private int findPositionOf(int elem) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == elem) {
                    return xyTo1D(i, j);
                }
            }
        }
        return -1;
    }

    private boolean isValid(int row, int col) {
        return (row >= 0 && row <= size - 1) && (col >= 0 && col <= size - 1);
    }

    private Boolean isBlock(int i, int j) {
        return grid[i][j] != 0;
    }

    private static void swap(Board b, int i, int j) {
        int row1 = b.getRow(i);
        int col1 = b.getCol(i);
        int row2 = b.getRow(j);
        int col2 = b.getCol(j);
        int t = b.grid[row1][col1];
        b.grid[row1][col1] = b.grid[row2][col2];
        b.grid[row2][col2] = t;
    }
}

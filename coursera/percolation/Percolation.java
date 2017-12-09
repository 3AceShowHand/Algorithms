/**
 * Author:     Christopher
 * Written:    2017/4/14
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;
    private int count;
    private WeightedQuickUnionUF tf;
    private WeightedQuickUnionUF bf;
    private int top;
    private int bottom;
    private int size;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("The size of Percolation must positive");
        }
        grid = new boolean[n+2][n+2];
        tf = new WeightedQuickUnionUF(n*n+1);
        bf = new WeightedQuickUnionUF(n*n+2);
        top = n * n;
        bottom = top + 1;
        size = n;
        count = 0;

        for (int col = 1; col <= size; col++) {
            tf.union(top, xyTo1D(1, col));
            bf.union(top, xyTo1D(1, col));
            bf.union(bottom, xyTo1D(size, col));
        }
    }

    // convert 2d index to 1d
    private int xyTo1D(int row, int col) {
        return size * (row-1) + (col-1);
    }

    // get row index from 2d index
    private int getRow(int idx) {
        return idx / size + 1;
    }

    // get col index from 2d index
    private int getCol(int idx) {
        return idx % size + 1;
    }

    private int[] getNeighborIdx1D(int row, int col) {
        int len = 4;
        if (row == 1) len -= 1;
        if (row == size) len -= 1;
        if (col == 1) len -= 1;
        if (col == size) len -= 1;

        int[] neighbors = new int[len];

        int i = 0;
        while (i < len) {
            if (validate(row-1, col)) {
                neighbors[i++] = xyTo1D(row-1, col);
            }
            if (validate(row, col+1)) {
                neighbors[i++] = xyTo1D(row, col+1);
            }
            if (validate(row+1, col)) {
                neighbors[i++] = xyTo1D(row+1, col);
            }
            if (validate(row, col-1)) {
                neighbors[i++] = xyTo1D(row, col-1);
            }
        }
        return neighbors;
    }

    public void open(int row, int col) {
        if (!validate(row, col)) {
            throw new IndexOutOfBoundsException("row or col must in range 1" + " and " + size);
        }

        if (isOpen(row, col)) {
            return;
        }
        grid[row][col] = true;
        count++;
        int currentIdx = xyTo1D(row, col);
        int[] neighbors = getNeighborIdx1D(row, col);
        for (int i = 0; i < neighbors.length; i++) {
            int neighborIdx = neighbors[i];
            int r = getRow(neighborIdx);
            int l = getCol(neighborIdx);
            if (isOpen(r, l)) {
                tf.union(neighborIdx, currentIdx);
                bf.union(neighborIdx, currentIdx);
            }
        }

    }

    private boolean validate(int row, int col) {
        return (row > 0 && row <= size) && (col > 0 && col <= size);
    }

    private void checkValidate(int row, int col) {
        if (!validate(row, col)) {
            throw new IndexOutOfBoundsException("row or col must in range 1" + " and " + size);
        }
    }

    public boolean isOpen(int row, int col) {
        checkValidate(row, col);
        return grid[row][col];
    }

    public boolean isFull(int row, int col) {
        checkValidate(row, col);
        return isOpen(row, col) && tf.connected(top, xyTo1D(row, col));
    }

    public int numberOfOpenSites() {
        return count;
    }

    public boolean percolates() {
        return bf.connected(top, bottom);
    }

}

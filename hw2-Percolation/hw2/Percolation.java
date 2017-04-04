package hw2;                       

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    private int count;
    private WeightedQuickUnionUF uf;
    private boolean[][] grid;
    private int top;

    /**initialize a grid of sites and the first row is fulled.*/
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("The size of Percolation must positive");
        }
        uf = new WeightedQuickUnionUF(N * N + 1);
        grid = new boolean[N][N];
        count = 0;
        //set the last item in the uf be the top.
        top = N * N;
    }

    //convert 2d index to 1d
    private int xyTo1D(int row, int col) {
        return row * grid.length + col;
    }

    //get row index from 2d index
    private int getRow(int idx) {
        return idx / grid.length;
    }

    //get col index from 2d index
    private int getCol(int idx) {
        return idx % grid.length;
    }

    //check the 2d index of a site in grid
    private boolean validate(int row, int col) {
        return (row >= 0 && row < grid.length) && (col >= 0 && col < grid.length);
    }

    //get top, right, down, left neighbors 1d index if existed.
    private int[] getNeighborIdx1D(int row, int col) {
        int len = 4;
        if (row == 0 || row == grid.length-1) len -= 1;
        if (col == 0 || col == grid.length-1) len -= 1;
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
        if ((row < 0 || row >= grid.length) || (col < 0 || col >= grid.length))
                throw new IndexOutOfBoundsException("row or col idx must between 0 and " + (grid.length - 1));

        // open the certain site.
        grid[row][col] = true;
        count++;
        int currentSiteIdx = xyTo1D(row, col);

        //the first row always percolable.
        if (row == 0) {
            uf.union(top, currentSiteIdx);
        }
        //check the neighbors of current site.
        int[] neighbors = getNeighborIdx1D(row, col);
        for (int i = 0; i < neighbors.length; i++) {
            int neighborIdx = neighbors[i];
            int row2D = getRow(neighborIdx);
            int col2D = getCol(neighborIdx);
            if (isOpen(row2D, col2D) && !uf.connected(neighborIdx, currentSiteIdx)) {
                uf.union(neighborIdx, currentSiteIdx);
            }
        }

    }

    public boolean isOpen(int row, int col) {
        if ((row < 0 || row >= grid.length) || (col < 0 || col >= grid.length))
            throw new IndexOutOfBoundsException("row or col idx must between 0 and " + (grid.length - 1));
        return grid[row][col];
    }

    public boolean isFull(int row, int col) {
        if ((row < 0 || row >= grid.length) || (col < 0 || col >= grid.length))
            throw new IndexOutOfBoundsException("row or col idx must between 0 and " + (grid.length - 1));
        return uf.find(xyTo1D(row, col)) == top;
    }

    public int numberOfOpenSites() {
        return count;
    }

    public boolean percolates() {
        int size = grid.length;
        for (int col = 0; col < size; col++) {
            int currentSiteIdx = xyTo1D(size-1, col);
            if (uf.find(currentSiteIdx) == top)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}                       

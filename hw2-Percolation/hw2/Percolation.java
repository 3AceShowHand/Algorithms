package hw2;                       

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.ArrayList;

public class Percolation {

    private site[][] grid;
    private int numberOfOpenSite;
    private WeightedQuickUnionUF uf;

    /**initialize a grid of sites and the first row is fulled.*/
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("The size of Percolation must positive");
        }
        numberOfOpenSite = 0;
        grid = new site[N][N];
        for (int row = 0; row < N; row++){
            for (int col = 0; col < N; col++){
                if (row == 0) {
                    grid[row][col] = new site(true);
                } else {
                    grid[row][col] = new site(false);
                }
            }
        }
    }

    private class site {
        boolean open;
        boolean full;

        public site(boolean full) {
            this.open = false;
            this.full = full;
        }
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

    //return all valid neighbors of a certain site
    private site[] getNeighbors(int row, int col) {

    }

    public void open(int row, int col) {
        if ((row < 0 || row >= grid.length) || (col < 0 || col >= grid.length))
                throw new IndexOutOfBoundsException("row or col idx must between 0 and " + (grid.length - 1));
        grid[row][col].open = true;
        numberOfOpenSite += 1;
    }

    public boolean isOpen(int row, int col) {
        if ((row < 0 || row >= grid.length) || (col < 0 || col >= grid.length))
            throw new IndexOutOfBoundsException("row or col idx must between 0 and " + (grid.length - 1));
        return grid[row][col].open;
    }

    public boolean isFull(int row, int col) {
        if ((row < 0 || row >= grid.length) || (col < 0 || col >= grid.length))
            throw new IndexOutOfBoundsException("row or col idx must between 0 and " + (grid.length - 1));
        return grid[row][col].full;
    }

    public int numberOfOpenSites() {
        return numberOfOpenSite;
    }

    public boolean percolates() {
        return false;
    }

    public static void main(String[] args) {

    }
}                       

package hw2;                       

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private site[][] grid;
    private int numberOfOpenSite;

    /**initialize a grid of sites and the first row is fulled.*/
    public Percolation(int N) {
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

    public void open(int row, int col) {
        grid[row][col].open = true;
        numberOfOpenSite += 1;
    }

    public boolean isOpen(int row, int col) {
        return grid[row][col].open;
    }

    public boolean isFull(int row, int col) {
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

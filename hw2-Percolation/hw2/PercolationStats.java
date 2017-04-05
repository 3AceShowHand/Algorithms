package hw2;


import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    Percolation perc;
    int size;
    int times;
    double[] prob;

    private int getRow(int idx) {
        return idx / size;
    }

    private int getCol(int idx) {
        return idx % size;
    }

    public PercolationStats(int N, int T) {
        if (N < 0 || T <= 0)
            throw new IllegalArgumentException();
        size = N;
        times = T;
        prob = new double[T];
        int[] order = new int[size * size];
        for (int i = 0; i < order.length; i++)
            order[i] = i;

        for (int trial = 0; trial < T; trial++) {
            perc = new Percolation(size);
            StdRandom.shuffle(order);
            for (int i = 0; i < order.length; i++) {
                if (!perc.percolates()) {
                    perc.open(getRow(order[i]), getCol(order[i]));
                } else {
                    break;
                }
            }
            prob[trial] = perc.numberOfOpenSites() / order.length;
        }
    }

    public double mean() {
        return StdStats.mean(prob);
    }

    public double stddev() {
        return StdStats.stddev(prob);
    }

    public double confidenceLow() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(times));
    }

    public double confidenceHigh() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(times));
    }

}                       

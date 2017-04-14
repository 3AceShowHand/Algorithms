import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private Percolation perc;
    private int size;
    private int times;
    private double[] prob;

    public PercolationStats(int n, int t) {
        if (n <= 0 || t <= 0) {
            throw new IllegalArgumentException();
        }
        size = n;
        times = t;
        prob = new double[t];
        int[] order = new int[size * size];
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }
        for (int trial = 0; trial < t; trial++) {
            perc = new Percolation(size);
            StdRandom.shuffle(order);
            for (int i = 0; i < order.length; i++) {
                if (!perc.percolates()) {
                    perc.open(getRow(order[i]), getCol(order[i]));
                } else {
                    break;
                }
            }
            prob[trial] = perc.numberOfOpenSites() / (double) order.length;
        }
    }

    // get row index from 2d index
    private int getRow(int idx) {
        return idx / size + 1;
    }

    // get col index from 2d index
    private int getCol(int idx) {
        return idx % size + 1;
    }

    public double mean() {
        return StdStats.mean(prob);
    }

    public double stddev() {
        return StdStats.stddev(prob);
    }

    public double confidenceLo() {
        return mean() - ((1.96 * stddev()) / Math.sqrt(times));
    }

    public double confidenceHi() {
        return mean() + ((1.96 * stddev()) / Math.sqrt(times));
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Please give args of Percolation size and trials times");
        }
        int size = Integer.parseInt(args[0]);
        int times = Integer.parseInt(args[1]);
        PercolationStats stat = new PercolationStats(size, times);
        StdOut.println("mean                    = " + stat.mean());
        StdOut.println("stddev                  = " + stat.stddev());
        StdOut.println("95% confidence interval = " + "[" + stat.confidenceLo() +", " + stat.confidenceHi()+"]");
    }

}                       

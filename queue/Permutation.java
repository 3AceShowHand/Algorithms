import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Author:     Christopher
 * Written:    2017/4/21
 */
public class Permutation {

    public static void main(String[] args) {
        if (args.length != 2) {
            StdOut.print("Please give k and file name in command line.");
            return;
        }
        int k = Integer.parseInt(args[0]);
        String fileName = args[1];
        In in = new In(fileName);
        RandomizedQueue<String> rq = new RandomizedQueue<>();

        while (!in.isEmpty()) {
            rq.enqueue(in.readString());
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(rq.dequeue());
        }
    }

}

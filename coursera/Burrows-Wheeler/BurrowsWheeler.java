import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import java.util.Arrays;

public class BurrowsWheeler {

    // apply Burrows-Wheeler transform, reading from standard input and writing to standard output
    public static void transform() {
        String input = BinaryStdIn.readString();
        CircularSuffixArray csa = new CircularSuffixArray(input);

        int first = -1;
        for (int i = 0; i < csa.length(); i++) {
            if (csa.index(i) == 0) {
                first = i;
                break;
            }
        }
        BinaryStdOut.write(first);

        for (int i = 0; i < csa.length(); i++) {
            int idx = csa.index(i);
            int prev = getPrevIndex(idx, input.length());
            char c = input.charAt(prev);
            BinaryStdOut.write(c);
        }
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard output
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        char[] t = BinaryStdIn.readString().toCharArray();

        char[] next = new char[t.length];
        for (int i = 0; i < next.length; i++) {
            next[i] = (char) -1;
        }

        char[] sorted = new char[t.length];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = t[i];
        }
        Arrays.sort(sorted);

        for (int i = 0; i < sorted.length; i++) {
            char c = t[first];
            for (int j = 0; j < sorted.length; j++) {
                if (sorted[j] == c) {
                    int idx = j;
                    if (next[idx] != (char) -1) {
                        next[idx] = (char) first;
                        first = idx;
                    }
                }
            }
        }
        for (int i = 0; i < next.length; i++) {
            BinaryStdOut.write(next[i]);
        }

        BinaryStdOut.close();
    }

    private static int getPrevIndex(int idx, int length) {
        if (idx == 0) {
            return length - 1;
        } else {
            return idx - 1;
        }
    }

    // if args[0] is '-', apply Burrows-Wheeler transform
    // if args[0] is '+', apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if ("-".equals(args[0])) {
            transform();
        } else {
            inverseTransform();
        }
    }
}

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

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

    // apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        String t = BinaryStdIn.readString();


        int R = 256;
        int[] count = new int[R+1];
        int[] next = new int[t.length()];

        // Key-indexed counting
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)+1]++;
        }
        for (int i = 1; i < R+1; i++) {
            count[i] += count[i-1];
        }

        // Compute next & write the original string
        for (int i = 0; i < t.length(); i++) {
            next[count[t.charAt(i)]++] = i;
        }
        for (int i = next[first], c = 0; c < t.length(); i = next[i], c++) {
            BinaryStdOut.write(t.charAt(i));
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

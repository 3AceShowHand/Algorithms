import edu.princeton.cs.algs4.BinaryStdIn;

public class BurrowsWheeler {

    // apply Burrows-Wheeler transform, reading from standard input and writing to standard output
    public static void transform() {
        String input = BinaryStdIn.readString();
        CircularSuffixArray csa = new CircularSuffixArray(input);

        char endup = input.charAt(input.length() - 1);
        StringBuilder sb = new StringBuilder();
        int first = -1;
        for (int i = 0; i < csa.length(); i++) {
            int index = csa.index(i);
            char c = input.charAt(index);
            if (first == -1 && c == endup) {
                first = index;
            }
            sb.append(c);
        }

        String transformed = sb.toString();

        BinaryStdOut.write(first);
        BinaryStdOut.write(transformed);
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform, reading from standard input and writing to standard output
    public static void inverseTransform() {
        String input = BinaryStdIn.readString();

    }

    // if args[0] is '-', apply Burrows-Wheeler transform
    // if args[0] is '+', apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {

    }
}

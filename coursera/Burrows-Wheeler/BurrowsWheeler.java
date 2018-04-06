import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

import java.util.ArrayList;
import java.util.Arrays;

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
    // the inputs to inverseTransform is output of transform.
    public static void inverseTransform() {
        String input = BinaryStdIn.readString();                    // t
        int first = BinaryStdIn.readInt();

        char[] firstColumn = (new String(input)).toCharArray();
        Arrays.sort(firstColumn);
        ArrayList<Character> sortedFirst = new ArrayList<>();
        for (char c: firstColumn) {
            sortedFirst.add(c);
        }

        int[] next = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(first);
            int index = sortedFirst.indexOf(c);
            next[index] = first;
            first = index;
        }
        for (int i = 0; i < next.length; i++) {
            BinaryStdOut.write(next[i]);
        }
        BinaryStdOut.close();
    }

    // if args[0] is '-', apply Burrows-Wheeler transform
    // if args[0] is '+', apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0] == "-") {
            transform();
        } else {
            inverseTransform();
        }
    }
}

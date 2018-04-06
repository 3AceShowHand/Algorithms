import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import java.util.LinkedList;

public class MoveToFront {

    private static LinkedList<Character> init() {
        int[] indexes = new int[256];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        char[] characters = Alphabet.EXTENDED_ASCII.toChars(indexes).toCharArray();
        LinkedList<Character> sequences = new LinkedList<>();
        for (char c : characters) {
            sequences.add(c);
        }
        return sequences;
    }

    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        // maintain an ordered sequence of 256 extended ASCII characters.
        LinkedList<Character> sequences = init();

        while (!BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            int output = sequences.indexOf(c);
            BinaryStdOut.write(output);
            if (output != 0) {
                sequences.remove(c);
                sequences.addFirst(c);
            }
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        LinkedList<Character> sequences = init();
        while (!BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            BinaryStdOut.write(c);
            if (sequences.indexOf(c) != 0) {
                sequences.remove(c);
                sequences.addFirst(c);
            }
            BinaryStdOut.close();
        }
    }

    // if args[0] is '-', apply move-to-front encoding
    // if args[0] is '+', apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0] == "-") {
            encode();
        } else{
            decode();
        }
    }
}
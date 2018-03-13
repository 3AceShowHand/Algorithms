/**
 * @author king
 */

import edu.princeton.cs.algs4.SET;

import java.util.ArrayList;

public class BoggleSolver {

    private final SET<String> dict;

    public BoggleSolver(String[] dictionary) {
        if (dictionary == null) {
            throw new IllegalArgumentException("Given dictionary is invalid.");
        }
        dict = new SET();
        for (String item: dictionary) {
            dict.add(item);
        }
    }

    public Iterable<String> getAllValidWords(BoggleBoard board) {
        if (board == null) {
            throw new IllegalArgumentException("Given board is invalid");
        }
        ArrayList<String> validWords = new ArrayList<>();
        return validWords;
    }

    // return the score of the given word if it is in the dictionary, zero otherwise.
    public int scoreOf(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Given word is invalid");
        }
        int length = word.length();
        if (!dict.contains(word)) {
            return 0;
        } else if (length <= 2) {
            return 0;
        } else if (length <= 4) {
            return 1;
        } else if (length == 5) {
            return 2;
        } else if (length == 6) {
            return 3;
        } else if (length == 7) {
            return 5;
        } else {
            return 11;
        }
    }

}

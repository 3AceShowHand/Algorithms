/**
 * @author king
 */

import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.TST;
import edu.princeton.cs.algs4.StdRandom;

public class BoggleSolver {

    private final TST<Integer> dict;

    public BoggleSolver(String[] dictionary) {
        fisherYatesShuffle(dictionary);
        if (dictionary == null) {
            throw new IllegalArgumentException("Given dictionary is invalid.");
        }
        dict = new TST<>();
        for (String item: dictionary) {
            dict.put(item, scoreOf(item));
        }
    }

    public Iterable<String> getAllValidWords(BoggleBoard board) {
        if (board == null) {
            throw new IllegalArgumentException("Given board is invalid");
        }

        boolean marked[][] = new boolean[board.rows()][board.cols()];
        SET<String> validWords = new SET<>();

        StringBuilder prefix = new StringBuilder();

        dfs(board, 0, 0, prefix, marked, validWords);

        return validWords;
    }

    // return the score of the given word if it is in the dictionary, zero otherwise.
    public int scoreOf(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Given word is invalid");
        }
        int length = word.length();
        if (!dict.contains(word) || length <= 2) {
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

    private void dfs(BoggleBoard board, int row, int col, StringBuilder prefix, boolean[][] marked, SET<String> result) {
        if (marked[row][col]) {
            return;
        }

        char c = board.getLetter(row, col);
        if (c == 'Q') {
            prefix.append("QU");
        } else {
            prefix.append(c);
        }
        String word = prefix.toString();

        if (dict.keysWithPrefix(word).) {
            if (c == 'Q') {
                prefix.deleteCharAt(prefix.length()-1);
                prefix.deleteCharAt(prefix.length()-1);
            } else {
                prefix.deleteCharAt(prefix.length()-1);
            }
            return;
        }

        if (word.length() > 2 && dict.contains(word)) {
            result.add(word);
        }
        marked[row][col] = true;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else {
                    int newrow = row + i;
                    int newcol = col + j;
                    if (newrow >= 0 && newrow < board.rows() && newcol >= 0 && newcol < board.cols() && !marked[newrow][newcol]) {
                        dfs(board, newrow, newcol, prefix, marked, result);
                    }
                }
            }
        }
        marked[row][col] = false;
    }

    private void fisherYatesShuffle(String[] strs) {
        // implementation of fisher-Yates shuffle algorithm
        int last = strs.length-1;
        for (int i = 0; i < last; last--) {
            int idx = StdRandom.uniform(last+1);
            String t = strs[last];
            strs[last] = strs[idx];
            strs[idx] = t;
        }
    }

    public static void main(String[] args) {
        In in = new In(args[0]);

        BoggleBoard board = new BoggleBoard(args[1]);

        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        int score = 0;

        Iterable<String> validWords = solver.getAllValidWords(board);
        for (String word : validWords) {
            StdOut.println(word);
            score += solver.scoreOf(word);
        }
        StdOut.println("Score = " + score);
    }

}

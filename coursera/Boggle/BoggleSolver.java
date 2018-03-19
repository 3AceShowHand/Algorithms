/**
 * @author king
 */

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdOut;

public class BoggleSolver {

    private static class RwayTrie {
        private final int R;
        private final Alphabet alpha;
        private Node root;

        private class Node {
            private Integer value;
            private Node[] next = new Node[R];
        }

        public RwayTrie(Alphabet alphabet) {
            alpha =  alphabet;
            R = alphabet.radix();
        }

        private Node put(Node x, String key, int val, int d) {
            if (x == null) {
                x = new Node();
            }
            if (d == key.length()) {
                x.value = val;
                return x;
            }
            char c = key.charAt(d);
            int idx = alpha.toIndex(c);
            x.next[idx] = put(x.next[idx], key, val, d+1);
            return x;
        }

        public void put(String key, int val) {
            root = put(root, key, val, 0);
        }

        private Node get(Node x, String key, int d) {
            if (x == null) {
                return null;
            }
            if (d == key.length()) {
                return x;
            }
            char c = key.charAt(d);
            int idx = alpha.toIndex(c);
            return get(x.next[idx], key, d+1);
        }

        private boolean hasKeyWithPrefix(Node x, String prefix, int d) {
            if (x == null) {
                return false;
            }
            if (d == prefix.length()) {
                return x.next != null;
            }
            char c = prefix.charAt(d);
            int idx = alpha.toIndex(c);
            return hasKeyWithPrefix(x.next[idx], prefix, d+1);
        }

        public Integer get(String key) {
            Node x = get(root, key, 0);
            if (x == null) {
                return null;
            }
            return x.value;
        }

        public boolean contains(String key) {
            return get(key) != null;
        }

        public boolean hasKeyWithPrefix(String prefix) {
            return hasKeyWithPrefix(root, prefix, 0);
        }
    }

    private final RwayTrie trie;
    private final SET<String> dict;

    public BoggleSolver(String[] dictionary) {

        Alphabet alphabet = Alphabet.UPPERCASE;
        trie = new RwayTrie(alphabet);
        dict = new SET<>();

        for (String s: dictionary) {
            trie.put(s, scoreOf(s));
            dict.add(s);
        }
    }

    public Iterable<String> getAllValidWords(BoggleBoard board) {
        if (board == null) {
            throw new IllegalArgumentException("Given board is invalid");
        }
        SET<String> validWords = new SET<>();

        boolean[][] marked = new boolean[board.rows()][board.cols()];
        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.cols(); j++) {
                dfs(board, i, j, "", marked, validWords);
            }
        }
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

    private void dfs(BoggleBoard board, int row, int col, String prefix,
                     boolean[][] marked, SET<String> result) {
        if (marked[row][col]) {
            return;
        }
        char c = board.getLetter(row, col);
        String word = (c == 'Q' ? (prefix + "QU") : (prefix + c));

        if (!trie.hasKeyWithPrefix(word)) {
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
                    if (newrow >= 0 && newrow < board.rows()
                            && newcol >= 0 && newcol < board.cols() && !marked[newrow][newcol]) {
                        dfs(board, newrow, newcol, word, marked, result);
                    }
                }
            }
        }
        marked[row][col] = false;
    }

     public static void main(String[] args) {

     }
}

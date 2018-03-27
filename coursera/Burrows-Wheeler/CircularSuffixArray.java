import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class CircularSuffixArray {

    private String value;
    private String[] suffixes;
    private Integer[] index;

    public CircularSuffixArray(String s) {
        value = new String(s);
        suffixes = new String[value.length()];
        for (int i = 0; i < value.length(); i++) {
            String suffix = value.substring(i, value.length()) + value.substring(0, i);
            suffixes[i] = suffix;
        }
        ArrayIndexComparator comparator = new ArrayIndexComparator(suffixes);
        index = comparator.createIndexArray();
        Arrays.sort(index, comparator);
    }

    private class ArrayIndexComparator implements Comparator<Integer> {
        private final String[] array;

        public ArrayIndexComparator(String[] arr) {
            array = arr;
        }

        public Integer[] createIndexArray() {
            Integer[] index = new Integer[array.length];
            for (int i = 0; i < index.length; i++) {
                index[i] = i;
            }
            return index;
        }

        @Override
        public int compare(Integer a, Integer b) {
            return array[a].compareTo(array[b]);
        }

    }

    // length of s
    public int length() {
        return value.length();
    }


    public int index(int i) {
        return index[i];
    }

    // unit testing (required)
    public static void main(String[] args) {
        String s = "ABRACADABRA!";
        CircularSuffixArray t = new CircularSuffixArray(s);
        for (int i = 0; i < t.suffixes.length; i++) {
            StdOut.println(t.suffixes[i]);
        }

        for (int i = 0; i < t.index.length; i++) {
            StdOut.println(t.index[i]);
        }

    }

}

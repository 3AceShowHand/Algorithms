import java.util.Arrays;
import java.util.Comparator;

public class CircularSuffixArray {

    // private ArrayList<Integer> indexes;
    private final Integer[] indexes;

    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new IllegalArgumentException("invalid null input constructor.");
        }

        indexes = new Integer[s.length()];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        ArrayIndexComparator comparator = new ArrayIndexComparator(s);
        Arrays.sort(indexes, comparator);
    }

    private class ArrayIndexComparator implements Comparator<Integer> {

        private final String s;

        ArrayIndexComparator(String s) {
            this.s = s;
        }

        private int getNextIndex(int i) {
            return (i + 1) % s.length();
        }

        @Override
        public int compare(Integer a, Integer b) {
            int aNext = a;
            int bNext = b;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(aNext) == s.charAt(bNext)) {
                    aNext = getNextIndex(aNext);
                    bNext = getNextIndex(bNext);
                } else if (s.charAt(aNext) < s.charAt(bNext)) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;
        }
    }

    // length of s
    public int length() {
        return indexes.length;
    }

    public int index(int i) {
        if (i >= length() || i < 0) {
            throw new IllegalArgumentException("i is out of index's range.");
        }
        return indexes[i];
    }
}

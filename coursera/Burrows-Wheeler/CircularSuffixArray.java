import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;


public class CircularSuffixArray {

    private ArrayList<Integer> indexes;

    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new IllegalArgumentException("invalid null input constructor.");
        }

        // given input s, maintain a map of characters c in s to indices of c
        TreeMap<Character, ArrayList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }

        indexes = new ArrayList<>();

        ArrayIndexComparator comparator = new ArrayIndexComparator(s);
        for (Map.Entry<Character, ArrayList<Integer>> pairs: map.entrySet()) {
            ArrayList<Integer> values = pairs.getValue();
            values.sort(comparator);
            indexes.addAll(values);
        }
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
            int aNext = getNextIndex(a);
            int bNext = getNextIndex(b);

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
        return indexes.size();
    }


    public int index(int i) {
        if (i > length()) {
            throw new IllegalArgumentException("i is out of index's range.");
        }
        return indexes.get(i);
    }

    // unit testing (required)
    public static void main(String[] args) {
        String s = "ABRACADABRA!";
        CircularSuffixArray t = new CircularSuffixArray(s);

        StdOut.printf("the length of s is: %s\n", t.length());
        StdOut.println(t.indexes);
    }
}

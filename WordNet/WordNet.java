import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;
import java.lang.*;
import java.lang.IllegalArgumentException;
import java.util.LinkedList;


public class WordNet {

    private Bag<Integer>[] adj;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        if(synsets == null || hypernyms == null) {
            throw new IllegalArgumentException("Argument shouldn't be null, please enter synsets and hypernyms");
        }

        String[] syns = new In(synsets).readAllLines();
        String[] hypers = new In(hypernyms).readAllLines();
        adj = (Bag<Integer>[]) new Bag[syns.length];
        for (int i = 0; i < syns.length; i++) {
            //int currId = Integer.parseInt(syns[i].split(",")[0]);
            adj[i] = new Bag<>();
        }
        for (int i =0; i < hypers.length; i++) {
            int[] triple = parseIntArray(hypers[i].split(","));
            int id = triple[0];
            for (int j = 1; j < triple.length; j++) {
                adj[id].add(triple[j]);
            }
        }
        StdOut.print("pause");
    }

    private static int[] parseIntArray(String[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = Integer.parseInt(arr[i]);
        }
        return res;
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
           return null;
    }
    
    // is the word a WordNet noun?
    public boolean isNoun(String word) {
           return true;
    }
    
    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        if (!isNoun(nounA) && !isNoun(nounB)) {
            throw new IllegalArgumentException("nounA or nounB is not a real noun.");
        }
        return 0;
    }
    
    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        if (!isNoun(nounA) && !isNoun(nounB)) {
            throw new IllegalArgumentException("nounA or nounB is not a real noun.");
        }
        return null;
    }
    
    // do unit testing of this class
    public static void main(String[] args) {
        WordNet net = new WordNet("synsets.txt", "hypernyms.txt");
    }
}
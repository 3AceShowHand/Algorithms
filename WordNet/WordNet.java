import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Topological;
import edu.princeton.cs.algs4.In;
import java.util.HashMap;
import java.util.Map;


public class WordNet {

    private final Digraph graph;
    private final HashMap<Integer, String> map;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null) {
            throw new IllegalArgumentException("Argument shouldn't be null, please enter synsets and hypernyms");
        }
        In synContent = new In(synsets);
        map = new HashMap<>();
        while (synContent.hasNextLine()) {
            String[] current = synContent.readLine().split(",");
            int id = Integer.parseInt(current[0]);
            String value = current[1];
            map.put(id, value);
        }
        graph = new Digraph(map.size());

        In hyperContent = new In(hypernyms);
        while (hyperContent.hasNextLine()) {
            String currLine = hyperContent.readLine();
            int[] content = parseIntArray(currLine.split(","));
            int id = content[0];
            for (int i = 1; i < content.length; i++) {
                graph.addEdge(id, content[i]);
            }
        }
        // Check whether is a DAG.
        Topological topOrder = new Topological(graph);
        if (!topOrder.hasOrder()) {
            throw new IllegalArgumentException("Construted WordNet is not a DAG");
        }
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
           return map.values();
    }
    
    // is the word a WordNet noun?
    public boolean isNoun(String word) {
           return map.containsValue(word);
    }

    // distance is the minimum length of any ancestral path between any synset v of A and any synset w of B.
    public int distance(String nounA, String nounB) {
        if (!isNoun(nounA) && !isNoun(nounB)) {
            throw new IllegalArgumentException("nounA or nounB is not a real noun.");
        }
        Integer idA = null;
        Integer idB = null;
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            Integer key = e.getKey();
            String value = e.getValue();
            if (value.equals(nounA)) {
                idA = key;
            } else if (value.equals(nounB)) {
                idB = key;
            }
            if (idA != null && idB != null) {
                break;
            }
        }
        SAP sap = new SAP(this.graph);
        int distance = sap.length(idA, idB);

        return distance;
    }
    
    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        if (!isNoun(nounA) && !isNoun(nounB)) {
            throw new IllegalArgumentException("nounA or nounB is not a real noun.");
        }
        Integer idA = null;
        Integer idB = null;
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            Integer key = e.getKey();
            String value = e.getValue();
            if (value.equals(nounA)) {
                idA = key;
            } else if (value.equals(nounB)) {
                idB = key;
            }
            if (idA != null && idB != null) {
                break;
            }
        }

        SAP sap = new SAP(this.graph);
        int id = sap.ancestor(idA, idB);

        return map.get(id);
    }
}
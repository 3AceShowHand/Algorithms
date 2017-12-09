import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.DirectedDFS;
import java.util.ArrayList;
import java.util.HashMap;


public class WordNet {

    private final HashMap<String, ArrayList<Integer>> value2key;
    private final HashMap<Integer, String> map;
    private final SAP sap;

    public WordNet(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null) {
            throw new IllegalArgumentException("Argument shouldn't be null, please enter synsets and hypernyms");
        }

        In synCont = new In(synsets);
        In hyperCont = new In(hypernyms);

        value2key = new HashMap<>();
        map = new HashMap<>();

        while (synCont.hasNextLine()) {
            String[] current = synCont.readLine().split(",");
            int id = Integer.parseInt(current[0]);
            String synNouns = current[1];
            map.put(id, synNouns);
            for (String s: synNouns.split(" ")) {
                if (value2key.containsKey(s)) {
                    value2key.get(s).add(id);
                } else {
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(id);
                    value2key.put(s, t);
                }
            }
        }

        Digraph graph = new Digraph(map.size());

        while (hyperCont.hasNextLine()) {
            int[] content = parseIntArray(hyperCont.readLine().split(","));
            int id = content[0];
            for (int i = 1; i < content.length; i++) {
                int dest = content[i];
                graph.addEdge(id, dest);
            }
        }
        DirectedCycle chcker = new DirectedCycle(graph);
        if (chcker.hasCycle()) {
            throw new IllegalArgumentException("This is not a rooted DAG");
        }

        SET<Integer> roots = new SET<Integer>();
        for (int i = 0; i < graph.V(); i++) {
            DirectedDFS dfs = new DirectedDFS(graph, i);
            if (dfs.count() == 1) {
                roots.add(i);
            }
        }
        if (roots.size() > 1) {
            throw new IllegalArgumentException("Has more than one root.");
        }

        sap = new SAP(graph);

    }

    private static int[] parseIntArray(String[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = Integer.parseInt(arr[i]);
        }
        return res;
    }

    public Iterable<String> nouns() {
        return value2key.keySet();
    }

    public boolean isNoun(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Given a null object to check");
        }
        return value2key.keySet().contains(word);
    }

    public int distance(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException("nounA or nounB is not a real noun.");
        }

        Iterable<Integer> idA = value2key.get(nounA);
        Iterable<Integer> idB = value2key.get(nounB);

        int distance = sap.length(idA, idB);

        return distance;
    }

    public String sap(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) {
            throw new IllegalArgumentException("nounA or nounB is not a real noun.");
        }

        Iterable<Integer> idA = value2key.get(nounA);
        Iterable<Integer> idB = value2key.get(nounB);

        int id = sap.ancestor(idA, idB);

        return id == -1 ? null : map.get(id);
    }
}
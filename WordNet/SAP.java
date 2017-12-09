import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import java.util.HashMap;


public class SAP {

    private final Digraph net;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        if (G == null) {
            throw new IllegalArgumentException("Given a null Digraph object");
        }

        net = new Digraph(G);
    }

    private static boolean checkInRange(int v, Digraph g) {
        return 0 <= v && v < g.V();
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        if (!checkInRange(v, net) || !checkInRange(w, net)) {
            throw new IllegalArgumentException("argument v or w is not between 0 and the size of current digraph");
        }

        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(net, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(net, w);


        int shortest = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < net.V(); i++) {
            if (bfsV.hasPathTo(i)) {
                map.put(i, bfsV.distTo(i));
            }
        }
        for (int i = 0; i < net.V(); i++) {
            if (map.containsKey(i) && bfsW.hasPathTo(i)) {
                int current = map.get(i).intValue() + bfsW.distTo(i);
                if (current < shortest) {
                    shortest = current;
                }
            }
        }
        if (Integer.compare(shortest, Integer.MAX_VALUE) == -1) {
            return shortest;
        }
        return -1;
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        if (!checkInRange(v, net) || !checkInRange(w, net)) {
            throw new IllegalArgumentException("argument v or w is not between 0 and the size of current digraph");
        }

        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(net, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(net, w);

        int shortest = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < net.V(); i++) {
            if (bfsV.hasPathTo(i)) {
                map.put(i, bfsV.distTo(i));
            }
        }
        int res = -1;
        for (int i = 0; i < net.V(); i++) {
            if (map.containsKey(i) && bfsW.hasPathTo(i)) {
                int current = map.get(i) + bfsW.distTo(i);
                if (current < shortest) {
                    shortest = current;
                    res = i;
                }
            }
        }
        return res;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null) {
            throw new IllegalArgumentException("Given a null Iterable object to argument v");
        }
        if (w == null) {
            throw new IllegalArgumentException("Given a null Iterable object to argument w");
        }
        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(net, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(net, w);

        int shortest = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < net.V(); i++) {
            if (bfsV.hasPathTo(i)) {
                map.put(i, bfsV.distTo(i));
            }
        }
        for (int i = 0; i < net.V(); i++) {
            if (map.containsKey(i) && bfsW.hasPathTo(i)) {
                int current = map.get(i) + bfsW.distTo(i);
                if (current < shortest) {
                    shortest = current;
                }
            }
        }
        if (Integer.compare(shortest, Integer.MAX_VALUE) == -1) {
            return shortest;
        }
        return -1;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null) {
            throw new IllegalArgumentException("Given a null Iterable object to argument v");
        }
        if (w == null) {
            throw new IllegalArgumentException("Given a null Iterable object to argument w");
        }

        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(net, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(net, w);

        int shortest = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < net.V(); i++) {
            if (bfsV.hasPathTo(i)) {
                map.put(i, bfsV.distTo(i));
            }
        }
        int res = -1;
        for (int i = 0; i < net.V(); i++) {
            if (map.containsKey(i) && bfsW.hasPathTo(i)) {
                int current = map.get(i) + bfsW.distTo(i);
                if (current < shortest) {
                    shortest = current;
                    res = i;
                }
            }
        }
        return res;
    }

//    public static void main(String[] args) {
//        int v = 0;
//        int w = 1;
//        In in1 = new In(args[0]);
//        In in2 = new In(args[1]);
//        SAP sap1 = new SAP(new Digraph(in1));
//        SAP sap2 = new SAP(new Digraph(in2));
//        StdOut.println(sap1.length(v, w));
//    }
}

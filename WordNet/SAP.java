import edu.princeton.cs.algs4.Digraph;
import java.lang.*;


public class SAP {

    private Digraph net;
    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        if (G == null) {
            throw new IllegalArgumentException("Given a null Digraph object");
        }
        net = new Digraph(G);
    }

    private static boolean checkInRange(int v, Digraph g) {
        return 0 < v && v < g.V();
    }
    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        if (!checkInRange(v, net) || !checkInRange(w, net)) {
            throw new IllegalArgumentException("argument v or w is not between 0 and the size of current digraph");
        }
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        if (!checkInRange(v, net) || !checkInRange(w, net)) {
            throw new IllegalArgumentException("argument v or w is not between 0 and the size of current digraph");
        }

        return 0;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null) {
            throw new IllegalArgumentException("Given a null Iterable object to argument v");
        }
        if (w == null) {
            throw new IllegalArgumentException("Given a null Iterable object to argument w");
        }
        return 0;
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        if (v == null) {
            throw new IllegalArgumentException("Given a null Iterable object to argument v");
        }
        if (w == null) {
            throw new IllegalArgumentException("Given a null Iterable object to argument w");
        }

        return 0;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length   = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}

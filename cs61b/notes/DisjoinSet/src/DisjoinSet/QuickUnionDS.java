package DisjoinSet;

/**
 * Created by Christopher on 2017/4/3.
 */
public class QuickUnionDS implements DisjoinSet {

    private int parents[];

    public QuickUnionDS(int N) {
        parents = new int[N];
        for (int i = 0; i < parents.length; i++)
            parents[i] = i;
    }

    private int findAncestor(int p) {
        while (parents[p] != p)
            p = parents[p];
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return findAncestor(p) == findAncestor(q);

    }

    @Override
    public void connect(int p, int q) {
        if (!isConnected(p, q)) {
            int i = findAncestor(p);
            int j = findAncestor(q);
            parents[i] = j;
        }
    }
}
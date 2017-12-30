package DisjoinSet;

/**
 * Created by Christopher on 2017/4/3.
 */
public class WeightedQuickUnionDSWithPathCompression implements DisjoinSet {
    private int parents[];
    private int size[];

    public WeightedQuickUnionDSWithPathCompression(int N) {
        parents = new int[N];
        size = new int[N];
        for(int i = 0; i < N; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    private int findAncestor(int p) {
        if (parents[p] == p) {
            return p;
        } else {
            parents[p] = findAncestor(parents[p]);
            return parents[p];
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return findAncestor(p) == findAncestor(q);
    }

    @Override
    public void connect(int p, int q) {
        int i = findAncestor(p);
        int j = findAncestor(q);
        if (i == j) return;
        if (size[i] < size[j]){
            parents[i] = j;
            size[j] += size[i];
        } else {
            parents[j] = i;
            size[i] += size[j];
        }
    }
}

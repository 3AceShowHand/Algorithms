package DisjoinSet;

import org.jetbrains.annotations.Contract;

/**
 * Created by Christopher on 2017/4/3.
 */
public class WeightedQuickUnionSet implements DisjoinSet {

    int[] parents;
    int[] size;

    public WeightedQuickUnionSet(int N) {
        parents = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }


    private int findAncestor(int p) {
        while (parents[p] != p)
            p = parents[p];
        return p;
    }

    @Override
    public void connect(int p, int q) {
        if (!isConnected(p, q)) {
            int i = findAncestor(p);
            int j = findAncestor(q);
            if (size[i] > size[j]) {
                parents[j] = i;
                size[i] += size[j];
            } else {
                parents[i] = j;
                size[j] += size[i];
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q){
        return findAncestor(p) == findAncestor(q);
    }
}

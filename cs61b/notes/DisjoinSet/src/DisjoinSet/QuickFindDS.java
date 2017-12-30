/**
 * Created by Christopher on 2017/4/3.
 */
package DisjoinSet;

public class QuickFindDS implements DisjoinSet {

    private int[] id;

    public QuickFindDS(int N) {
        id = new int[N];
        for(int i = 0; i < id.length; i++)
            id[i] = i;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public void connect(int p, int q) {
        for(int i = 0; i < id.length; i++)
            if (id[i] == id[q])
                id[i] = id[p];
    }

}

/**
 * Created by Christopher on 2017/4/3.
 */

package DisjoinSet;

public interface DisjoinSet {

    /** Checks to see if p and q connected. */
    boolean isConnected(int p, int q);

    /** Connect p and q if they didn't connected. */
    void connect(int p, int q);
}

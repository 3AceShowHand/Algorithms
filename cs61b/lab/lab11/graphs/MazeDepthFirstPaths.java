package graphs;

import java.util.Stack;

/**
 *  @author Josh Hug
 */
public class MazeDepthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;


    public MazeDepthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    private void dfs(int v) {
        marked[v] = true;
        announce();

        if (v == t) {
            targetFound = true;
        }

        if (targetFound) {
            return;
        }

        for (int w : maze.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                announce();
                distTo[w] = distTo[v] + 1;
                dfs(w);
                if (targetFound) {
                    return;
                }
            }
        }
    }

    private void dfsIterative(int v) {
        Stack<Integer> trace = new Stack<>();
        trace.push(v);

        while (!trace.isEmpty()) {
            int current = trace.pop();
            marked[current] = true;
            announce();
            if (current == t) {
                targetFound = true;
            }
            if (targetFound) {
                return;
            }
            for (int w: maze.adj(current)) {
                if (!marked[w]) {
                    edgeTo[w] = current;
                    distTo[w] = distTo[current] + 1;
                    trace.push(w);
                }
            }

        }
    }

    @Override
    public void solve() {
        // dfs(s);
        dfsIterative(s);
    }
}


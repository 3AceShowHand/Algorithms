package graphs;

import java.util.Stack;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private Maze maze;
    private int s;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        s = maze.xyTo1D(1, 1);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    private void cycleDetector () {
        Stack<Integer> trace = new Stack<>();
        trace.push(s);
        int current;
        while (!trace.isEmpty()) {
            current = trace.pop();
            marked[current] = true;
            announce();
            for (int w: maze.adj(current)) {
                if (!marked[w]) {
                    edgeTo[w] = current;
                    distTo[w] = distTo[current] + 1;
                    trace.push(w);
                } else if (w != edgeTo[current]) {
                    return;
                }
            }
        }
    }

    @Override
    public void solve() {
        cycleDetector();
    }

    // Helper methods go here
}


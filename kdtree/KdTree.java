import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

/**
 * Author:     Christopher
 * Written:    2017/5/20
 */
public class KdTree {

    private treeNode root;

    private static class treeNode {
        private Point2D point;
        private boolean isVerticle;
        private treeNode left;
        private treeNode right;

        public treeNode(Point2D p, boolean isVerticle) {
            this.point = p;
            this.isVerticle = isVerticle;
        }

    }

    public KdTree() {

    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private static int size(treeNode n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + size(n.left) + size(n.right);
        }
    }

    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for insert is null");
        }

    }

    private treeNode insert(treeNode n, Point2D p) {
        if (n == null) {
            return new treeNode(p, true);
        } else {
            return null;
        }
    }

    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for contains is null");
        }
        return false;
    }

    public void draw() {
        StdDraw.setPenRadius();
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException("Argument rect for range is null");
        }
        return null;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for nearest is null");
        }
        return null;
    }
}

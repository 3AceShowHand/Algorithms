import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

/**
 * Author:     Christopher
 * Written:    2017/5/20
 */
public class KdTree {

    private TreeNode root;

    private static class TreeNode implements Comparable<TreeNode> {
        private Point2D point;
        private boolean isVerticle;
        private TreeNode left;
        private TreeNode right;
        private int size;
        private RectHV rect;

        public TreeNode(Point2D p, boolean isVerticle, int size, RectHV rect) {
            this.point = p;
            this.isVerticle = isVerticle;
            this.size = size;
            this.rect = rect;
        }

        @Override
        public int compareTo(TreeNode other) {
            // compare x-coordinate
            // else y-coordinate
            if (this.isVerticle) {
                double thisX = this.point.x();
                double thatX = other.point.x();
                return Double.compare(thisX, thatX);
            } else {
                double thisY = this.point.y();
                double thatY = other.point.y();
                return Double.compare(thisY, thatY);
            }
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

    private int size(TreeNode n) {
        if (n == null) return 0;
        return n.size;
    }

    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for insert is null");
        }
        root = insert(root, p);
    }

    private TreeNode insert(TreeNode n, Point2D p) {
        if (n == null) {
            return new TreeNode(p, true, 1, new RectHV(0,0,1, 1));
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
        SET<Point2D> res = new SET<>();
        return res;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for nearest is null");
        }
        return null;
    }
}

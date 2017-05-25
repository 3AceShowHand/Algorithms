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

        public TreeNode(Point2D p, boolean isVerticle, int size) {
            this.point = p;
            this.isVerticle = isVerticle;
            this.size = size;
        }

        private TreeNode(Point2D p, int size) {
            this.point = p;
            this.size = size;
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

    private RectHV makeRect(TreeNode parent, TreeNode p) {

    }

    private TreeNode insert(TreeNode n, Point2D p) {
        if (n == null) {
            return new TreeNode(p, true, 1);
        } else {
            TreeNode newNode = new TreeNode(p, true, 1);
            int cmp = n.compareTo(newNode);
            if (cmp < 0) {
                n.left = insert(n.left, p);
                n.left.isVerticle = !n.isVerticle;
                n.left.rect = makeRect(n, n.left);
            } else if (cmp > 0) {
                n.right = insert(n.right, p);
                n.right.isVerticle = !n.isVerticle;
                n.right.rect = makeRect(n, n.right);
            } else {
                n.point = p;
            }
        }
        n.size = 1 + size(n.left) + size(n.right);
        return n;
    }

    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for contains is null");
        }
        return get(root, p) != null;
    }

    private Point2D get(TreeNode n, Point2D p) {
        if (n == null) {
            return null;
        } else {
            TreeNode t = new TreeNode(p, 1);
            int cmp = n.compareTo(t);
            if (cmp < 0) {
                return get(n.left, p);
            } else if (cmp > 0) {
                return get(n.right, p);
            } else {
                return n.point;
            }
        }
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

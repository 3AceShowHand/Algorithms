import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Queue;
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

        private TreeNode(Point2D p, int size) {
            this.point = p;
            this.size = size;
        }

        private TreeNode(Point2D p, boolean isVerticle, int size) {
            this(p, size);
            this.isVerticle = isVerticle;
        }

        public TreeNode(Point2D p, boolean isVerticle, int size, RectHV rect) {
            this(p, isVerticle, size);
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
        if (p == null) {
            throw new NullPointerException("Argument p for insert is null");
        }
        if (!contains(p)) {
            if (n == null) {
                RectHV rect = new RectHV(0, 0, 1, 1);
                return new TreeNode(p, true, 1, rect);
            } else {
                TreeNode newNode = new TreeNode(p, true, 1);
                if (goLeft(n, newNode)) {
                    n.left = insert(n.left, p);
                    n.left.isVerticle = !n.isVerticle;
                    n.left.rect = makeRect(n, n.left);
                } else {
                    n.right = insert(n.right, p);
                    n.right.isVerticle = !n.isVerticle;
                    n.right.rect = makeRect(n, n.right);
                }
            }
            n.size = 1 + size(n.left) + size(n.right);
            return n;
        }
        return null;
    }

    private RectHV makeRect(TreeNode parent, TreeNode p) {
        if (parent.isVerticle) {
            if (parent.left == p) {
                return new RectHV(parent.rect.xmin(), parent.point.x(), parent.rect.ymin(), parent.rect.ymax());
            } else {
                return new RectHV(parent.point.x(), parent.rect.xmax(), parent.rect.ymin(), parent.rect.ymax());
            }
        } else {
            if (parent.left == p) {
                return new RectHV(parent.rect.xmin(), parent.rect.xmax(), parent.rect.ymin(), parent.point.y());
            } else {
                return new RectHV(parent.rect.xmin(), parent.rect.xmax(), parent.point.y(), parent.rect.ymax());
            }
        }
    }

    private boolean goLeft(TreeNode parent, TreeNode that) {
        return parent.compareTo(that) < 0;
    }

    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for contains is null");
        }
        return get(root, p);
    }

    private boolean get(TreeNode n, Point2D p) {
        if (n == null) {
            return false;
        }
        TreeNode search = new TreeNode(p, 1);
        if (n.point.equals(p)) {
            return true;
        } else if (goLeft(n, search)) {
            return get(n.left, p);
        } else {
            return get(n.right, p);
        }
    }

    // Level order traverse kdtree and draw the rectangle correspoding to each node
    public void draw() {
        StdDraw.setPenRadius();
        Queue<TreeNode> nodes = new Queue<>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()) {
            TreeNode current = nodes.dequeue();
            if (current.isVerticle) {
                StdDraw.setPenColor(StdDraw.RED);
            } else {
                StdDraw.setPenColor(StdDraw.BLUE);
            }
            double halfX = (current.rect.xmax() - current.rect.xmin()) / 2;
            double halfY = (current.rect.ymax() - current.rect.ymin()) / 2;
            double xCenter = current.rect.xmin() + halfX;
            double yCenter = current.rect.ymin() + halfY;
            StdDraw.rectangle(xCenter, yCenter, halfX, halfY);
            nodes.enqueue(current.left);
            nodes.enqueue(current.right);
        }
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException("Argument rect for range is null");
        }
        SET<Point2D> res = new SET<>();
        Queue<TreeNode> q = new Queue<>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            TreeNode current = q.dequeue();
            if (rect.intersects(current.rect)) {
                if (rect.contains(current.point)) {
                    res.add(current.point);
                }
            }
            if (rect.intersects(current.left.rect)) {
                q.enqueue(current.left);
            }
            if (rect.intersects(current.right.rect)) {
                q.enqueue(current.right);
            }
        }
        return res;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for nearest is null");
        }
        return null;
    }

    public static void main(String[] args) {

    }
}

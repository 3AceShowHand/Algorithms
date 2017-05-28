import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;

/**
 * Author:     Christopher
 * Written:    2017/5/20
 */
public class KdTree {

    private TreeNode root;

    private static class TreeNode {
        private Point2D point;
        private boolean isVerticle;
        private TreeNode left;
        private TreeNode right;
        private int size;
        private RectHV rect;


        private TreeNode(Point2D p, boolean isVerticle, int size) {
            this.point = p;
            this.isVerticle = isVerticle;
            this.size = size;
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
        if (n == null) {
            return 0;
        }
        return n.size;
    }

    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for insert is null");
        }
        root = insert(root, p);
        addRect();
    }

    private TreeNode insert(TreeNode n, Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for insert is null");
        }
        if (!contains(p)) {
            if (n == null) {
                n = new TreeNode(p, true, 1);
            } else {
                if (goLeft(p, n)) {
                    n.left = insert(n.left, p);
                } else {
                    n.right = insert(n.right, p);
                }
            }
            n.size = 1 + size(n.left) + size(n.right);
            return n;
        } else {
            return null;
        }
    }

    private boolean goLeft(Point2D kid, TreeNode parent) {
        if (parent.isVerticle) {
            return Double.compare(kid.x(), parent.point.x()) < 0;
        } else {
            return Double.compare(kid.y(), parent.point.y()) < 0;
        }
    }

    private void addRect() {
        Queue<TreeNode> q = new Queue<>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            TreeNode current = q.dequeue();
            TreeNode parent = getParent(root, current);
            if (current.rect == null) {
                current.rect = makeRect(parent, current);
                if (parent != null) {
                    current.isVerticle = !parent.isVerticle;
                }
            }
            if (current.left != null) {
                q.enqueue(current.left);
            }
            if (current.right != null) {
                q.enqueue(current.right);
            }
        }
    }

    private TreeNode getParent(TreeNode n, TreeNode that) {
        if (n == null || that == null) {
            return null;
        } else {
            if (n.left == that || n.right == that) {
                return n;
            } else if (goLeft(that.point, n)) {
                return getParent(n.left, n);
            } else {
                return getParent(n.right, n);
            }
        }
    }

    private RectHV makeRect(TreeNode parent, TreeNode p) {
        RectHV rect;
        if (parent == null) {
            rect = new RectHV(0, 0, 1, 1);
        } else {
            if (parent.isVerticle) {
                if (parent.left == p) {
                    rect = new RectHV(parent.rect.xmin(), parent.rect.ymin(), parent.point.x(), parent.rect.ymax());
                } else {
                    rect = new RectHV(parent.point.x(), parent.rect.ymin(), parent.rect.xmax(), parent.rect.ymax());
                }
            } else {
                if (parent.left == p) {
                    rect = new RectHV(parent.rect.xmin(), parent.rect.ymin(), parent.rect.xmax(), parent.point.y());
                } else {
                    rect = new RectHV(parent.rect.xmin(), parent.point.y(), parent.rect.xmax(), parent.rect.ymax());
                }
            }
        }
        return rect;
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
        if (p == null) {
            return false;
        }
        if (n.point.equals(p)) {
            return true;
        } else if (goLeft(p, n)) {
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
                StdDraw.line(current.point.x(), current.rect.ymin(), current.point.x(), current.rect.ymax());
            } else {
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.line(current.rect.xmin(), current.point.y(), current.rect.xmax(), current.point.y());
            }
            if (current.left != null) {
                nodes.enqueue(current.left);
            }
            if (current.right != null) {
                nodes.enqueue(current.right);
            }
        }
    }

    // Filter subtree by level order the tree and check whether the point contained in the rectangle.
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
            if (current.left != null && rect.intersects(current.left.rect)) {
                q.enqueue(current.left);
            }
            if (current.right != null && rect.intersects(current.right.rect)) {
                q.enqueue(current.right);
            }
        }
        return res;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for nearest is null");
        }
        Point2D closest = null;
        double currentDist = Double.POSITIVE_INFINITY;
        Queue<TreeNode> q = new Queue<>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            TreeNode current = q.dequeue();
            double dist = p.distanceSquaredTo(current.point);
            if (Double.compare(dist, currentDist) < 0) {
                closest = current.point;
                currentDist = dist;
            }
            if (Double.compare(currentDist, current.left.rect.distanceSquaredTo(p)) >= 0) {
                q.enqueue(current.left);
            }
            if (Double.compare(currentDist, current.right.rect.distanceSquaredTo(p)) >= 0) {
                q.enqueue(current.right);
            }
        }
        return closest;
    }

//    public static void main(String[] args) {
//        KdTree tree = new KdTree();
//        In in = new In(args[0]);
//
//        while (!in.isEmpty()) {
//            double x = in.readDouble();
//            double y = in.readDouble();
//            Point2D p = new Point2D(x, y);
//            tree.insert(p);
//        }
//
//        Point2D target = new Point2D(0.2, 0.5);
//        boolean t = tree.contains(target);
//
//        if (t) {
//            StdOut.println("find target");
//        } else {
//            StdOut.print("contain works wrong");
//        }
//
//    }

}

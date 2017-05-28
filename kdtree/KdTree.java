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
    private int count;

    private static class TreeNode {
        private Point2D point;
        private boolean isVerticle;
        private TreeNode left;
        private TreeNode right;
        private int size;
        private RectHV rect;


        private TreeNode(Point2D p, boolean isVerticle, int size, RectHV rect) {
            this.point = p;
            this.isVerticle = isVerticle;
            this.size = size;
            this.rect = rect;
        }
    }

    public KdTree() {
        root = null;
        count = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return count;
    }


    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for insert is null");
        }

        if (root == null) {
            root = new TreeNode(p, true, 1, makeRect(null, p));
            count++;
        } else {
            TreeNode current = root;
            while (current != null) {
                if (current.point.equals(p)) {
                    return;
                } else {
                    if (goLeft(p, current)) {
                        if (current.left == null) {
                            current.left = new TreeNode(p, !current.isVerticle, 1, makeRect(current, p));
                            count++;
                        }
                        current = current.left;
                    } else {
                        if (current.right == null) {
                            current.right = new TreeNode(p, !current.isVerticle, 1, makeRect(current, p));
                            count++;
                        }
                        current = current.right;
                    }
                }
            }
        }
    }

    private boolean goLeft(Point2D kid, TreeNode parent) {
        if (parent.isVerticle) {
            return Double.compare(kid.x(), parent.point.x()) < 0;
        } else {
            return Double.compare(kid.y(), parent.point.y()) < 0;
        }
    }

    private RectHV makeRect(TreeNode parent, Point2D p) {
        RectHV rect;
        if (parent == null) {
            rect = new RectHV(0, 0, 1, 1);
        } else {
            if (parent.isVerticle) {
                if (parent.left != null && parent.left.point.equals(p)) {
                    double xmax = Math.max(parent.point.x(), parent.rect.xmax());
                    rect = new RectHV(parent.rect.xmin(), parent.rect.ymin(), xmax, parent.rect.ymax());
                } else {
                    double xmin = Math.min(parent.point.x(), parent.rect.xmin());
                    rect = new RectHV(xmin, parent.rect.ymin(), parent.rect.xmax(), parent.rect.ymax());
                }
            } else {
                if (parent.left != null && parent.left.point.equals(p)) {
                    double ymax = Math.max(parent.point.y(), parent.rect.ymax());
                    rect = new RectHV(parent.rect.xmin(), parent.rect.ymin(), parent.rect.xmax(), ymax);
                } else {
                    double ymin = Math.min(parent.point.y(), parent.rect.ymin());
                    rect = new RectHV(parent.rect.xmin(), ymin, parent.rect.xmax(), parent.rect.ymax());
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
}

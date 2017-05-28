import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
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
        private RectHV rect;


        private TreeNode(Point2D p, boolean isVerticle) {
            this.point = p;
            this.isVerticle = isVerticle;
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
            count++;
            root = new TreeNode(p, true);
            root.rect = makeRect(null, p);
        } else {
            TreeNode current = root;
            while (true) {
                if (current.point.compareTo(p) == 0) {
                    return;
                } else if (goLeft(p, current)) {
                    if (current.left == null) {
                        count++;
                        current.left = new TreeNode(p, !current.isVerticle);
                        current.left.rect = makeRect(current, p);
                        break;
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        count++;
                        current.right = new TreeNode(p, !current.isVerticle);
                        current.right.rect = makeRect(current, p);
                        break;
                    }
                    current = current.right;
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

    private boolean onBound(Point2D p) {
        return (Double.compare(p.x(), 0.0) == 0 || Double.compare(p.x(), 1.0) == 0
                || Double.compare(p.y(), 0.0) == 0 || Double.compare(p.y(), 1.0) == 0);
    }

    private RectHV makeRect(TreeNode parent, Point2D p) {
        RectHV rect;
        if (parent == null || p == null) {
            rect = new RectHV(0, 0, 1, 1);
        } else if (onBound(p)) {
            rect = new RectHV(parent.rect.xmin(), parent.rect.ymin(), parent.rect.xmax(), parent.rect.ymax());
        } else {
            if (parent.isVerticle) {
                if (parent.left != null && parent.left.point.equals(p)) {
                    rect = new RectHV(parent.rect.xmin(), parent.rect.ymin(), parent.point.x(), parent.rect.ymax());
                } else {
                    rect = new RectHV(parent.point.x(), parent.rect.ymin(), parent.rect.xmax(), parent.rect.ymax());
                }
            } else {
                if (parent.left != null && parent.left.point.equals(p)) {
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
        if (n.point.equals(p)) {
            return true;
        } else if (goLeft(p, n)) {
            return get(n.left, p);
        } else {
            return get(n.right, p);
        }
    }

    // Filter subtree by level order the tree and check whether the point contained in the rectangle.
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException("Argument rect for range is null");
        }
        SET<Point2D> set = new SET<>();
        range(root, rect, set);

        return set;
    }

    private void range(TreeNode current, RectHV rect, SET<Point2D> set) {
        if (current == null) {
            return;
        }
        if (current.rect.intersects(rect)) {
            if (rect.contains(current.point)) {
                set.add(current.point);
            }
        }
        range(current.left, rect, set);
        range(current.right, rect, set);
    }

    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Argument p for nearest is null");
        }
        return nearest(root, p, root.point);
    }

    private Point2D nearest(TreeNode current, Point2D target, Point2D closest) {
        if (current == null || Double.compare(current.rect.distanceSquaredTo(target), closest.distanceSquaredTo(target)) > 0) {
            return closest;
        }
        double dist = current.point.distanceSquaredTo(target);
        if (Double.compare(dist, closest.distanceSquaredTo(target)) < 0) {
            closest = current.point;
        }
        TreeNode close = null;
        TreeNode far = null;
        if ((current.isVerticle && (Double.compare(target.x(), current.point.x()) < 0))
                || (!current.isVerticle && (Double.compare(target.y(), current.point.y()) < 0))) {
            if (current.left != null) {
                close = current.left;
            }
            if (current.right != null) {
                far = current.right;
            }
        } else {
            if (current.right != null) {
                close = current.right;
            }
            if (current.left != null) {
                far = current.left;
            }
        }
        closest = nearest(close, target, closest);
        closest = nearest(far, target, closest);

        return closest;
    }

    // Level order traverse kdtree and draw the rectangle correspoding to each node
    public void draw() {
        StdDraw.setPenRadius();
        draw(root);
    }

    private void draw(TreeNode current) {
        if (current == null) {
            return;
        }
        if (current.isVerticle) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(current.point.x(), current.rect.ymin(), current.point.x(), current.rect.ymax());
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(current.rect.xmin(), current.point.y(), current.rect.xmax(), current.point.y());
        }

        draw(current.left);
        draw(current.right);
    }
}

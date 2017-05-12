import java.util.Comparator;

/**
 * Author:     Christopher
 * Written:    2017/4/23
 * This program solve the problem: Given a set of n distinct points in the plane,
 * find every (maximal) line segment that connects a subset of 4 or more of the points.
 */
public class FastCollinearPoints {

    LineSegment[] segments;

    /** find all line segments containing 4 or more points */
    public FastCollinearPoints(Point[] points) {
        // Applying sort method to each point in the points in turn

    }

    /** Sort points by slope to pivot point
     * Think p is the origin point.
     * For each other point q, determine the slope it makes with p
     * Sort points according to the slope they make with p. */
    private static void sort(Point[] points, int lo, int hi) {
        Point origin = points[0];


    }

    /** compare two point by the slope to pivot point.
     * if the same slope to pivot, compare by y position. */
    private static int less(Point pivot, Point lhs, Point rhs) {
        Comparator<Point> pc = pivot.slopeOrder();

        if (pc.compare(lhs, rhs) == 0) {
            return lhs.compareTo(rhs);
        } else {
            return pc.compare(lhs, rhs);
        }
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /** the number of line segments */
    public int numberOfSegments() {
        return segments.length;
    }

    /** the line segments */
    public LineSegment[] segments() {
        return segments;
    }

}

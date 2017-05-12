import java.util.ArrayList;
import java.util.Arrays;
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

        if (points == null) throw new NullPointerException("Point is null");
        for (int idx = 0; idx < points.length; idx++) {
            if (points[idx] == null) {
                throw new NullPointerException("Point in " + idx + " position is null");
            }
            for (int j = idx + 1; j < points.length; j++) {
                if (points[idx].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Duplicate points in the given points set.");
                }
            }
        }

        Point[]
        // Applying sort method to each point in the points in turn
        for (int idx = 0; idx < points.length; idx++) {
            Point[] copy = Arrays.copyOf(points, points.length);
            exch(points, 0, idx);
            Point[] others = Arrays.copyOfRange(points,1, points.length);
            sort(others, points[0]);
        }

    }

    private static void sort(Point[] points, Point pivot) {
        sort(points, 0, points.length-1, pivot);
    }

    /** Sort points by slope to pivot point
     * Think p is the origin point.
     * For each other point q, determine the slope it makes with p
     * Sort points according to the slope they make with p. */
    private static void sort(Point[] points, int lo, int hi, Point pivot) {
        Point origin = points[0];
        if (hi <= lo) {
            return;
        }
        int j = partition(points, lo, hi);
        sort(points, lo, j-1, pivot);
        sort(points, j+1, hi, pivot);
    }

    private static int partition(Point[] points, int lo, int hi, Point pivot) {
        int i = lo;
        int j = hi+1;
        while (true) {

        }
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

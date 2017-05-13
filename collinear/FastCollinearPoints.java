import java.util.ArrayList;
import java.util.Arrays;


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

        // Check input points without null reference and no duplicates.
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

        ArrayList<LineSegment> lines = new ArrayList<>();

        Point[] copy;
        // Applying sort method to each point in the points in turn
        for (int idx = 0; idx < points.length; idx++) {
            copy = Arrays.copyOf(points, points.length);
            exch(points, 0, idx);
            Point origin = points[0];
            Point[] others = Arrays.copyOfRange(points,1, points.length);
            Arrays.sort(others, origin.slopeOrder());

            // After sort others points by slope to origin point, find all adjacent tuples have more than 3 points
            // and find the min and the max point.
            int start = 0, end = 0;
            int count = 1;
            double currentSlope = origin.slopeTo(others[0]);
            for (int i = 1; i < others.length; i++) {
                double slope = origin.slopeTo(others[i]);
                if (slope == currentSlope) {
                    count += 1;
                    end += 1;
                } else {
                    // find a subarray contain 3 or more points have the same slope to origin point.
                    if ((end - start) >= 2) {
                        ArrayList<Point> subPoints = new ArrayList<>();
                        subPoints.add(origin);
                        for (int k = start; k <= end; k++) {
                            subPoints.add(others[k]);
                        }
                        Point startPoint = getStartPoint(subPoints);
                        Point endPoint = getEndPoint(subPoints);
                        lines.add(new LineSegment(startPoint, endPoint));
                    }

                    currentSlope = slope;
                    count = 1;
                    start = i;
                    end = start;
                }
            }

        }

    }

    private static void exch(Point[] a, int i, int j) {
        Point t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static Point getStartPoint(ArrayList<Point> pts) {
        Point start = pts.get(0);
        for (Point p: pts) {
            if (p.compareTo(start) == -1) {
                start = p;
            }
        }
        return start;
    }

    private static Point getEndPoint(ArrayList<Point> pts) {
        Point end = pts.get(0);
        for (Point p: pts) {
            if (p.compareTo(end) == 1) {
                end = p;
            }
        }
        return end;
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

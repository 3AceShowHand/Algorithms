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

        // Applying sort method to each point in the points in turn
        for (int idx = 0; idx < points.length; idx++) {
            Point[] copy = Arrays.copyOf(points, points.length);
            exch(copy, 0, idx);
            Point origin = copy[0];
            Point[] others = Arrays.copyOfRange(copy,1, points.length);
            Arrays.sort(others, origin.slopeOrder());

            // After sort others points by slope to origin point, find all adjacent tuples have more than 3 points
            // and find the min and the max point.
            int start = 0, end = 0;
            double currentSlope = origin.slopeTo(others[0]);
            for (int i = 1; i < others.length; i++) {
                double slope = origin.slopeTo(others[i]);
                if (slope == currentSlope) {
                    end += 1;
                } else {
                    // find a subarray contain 3 or more points have the same slope to origin point.
                    if ((end - start) >= 2) {
                        // if origin point lower than first point in the sub array.
                        Point[] sub = Arrays.copyOfRange(others,start, end+1);
                        Arrays.sort(sub);
                        if (origin.compareTo(sub[0]) == -1) {
                            Point endPoint = sub[sub.length-1];
                            lines.add(new LineSegment(origin, endPoint));
                        }
                    }
                    currentSlope = slope;
                    start = i;
                    end = start;
                }
            }

        }
        segments = lines.toArray(new LineSegment[lines.size()]);
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

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}

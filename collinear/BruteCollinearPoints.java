import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Author:     Christopher
 * Written:    2017/4/23
 * This program solve the problem: Given a set of n distinct points in the plane,
 * find every (maximal) line segment that connects a subset of 4 points.
 */

public class BruteCollinearPoints {

    LineSegment[] segments;

    /**
     * find all line segments containing 4 points
     */
    public BruteCollinearPoints(Point[] points) {
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
        Arrays.sort(points);

        //Point[] points = Arrays.pointsOf(points, points.length);
        //Arrays.sort(points);
        ArrayList<LineSegment> lines = new ArrayList<>();

        for (int p = 0; p < points.length - 3; p++) {
            for (int q = p + 1; q < points.length - 2; q++) {
                for (int r = q + 1; r < points.length - 1; r++) {
                    for (int s = r + 1; s < points.length; s++) {
                        Comparator<Point> pc = points[p].slopeOrder();
                        if ((pc.compare(points[q], points[r]) == 0) && (pc.compare(points[q], points[s]) == 0)) {
                            LineSegment line = new LineSegment(points[p], points[s]);
                            lines.add(line);
                        }
                    }
                }
            }
        }
        segments = lines.toArray(new LineSegment[lines.size()]);
    }

    /**
     * the number of line segments
     */
    public int numberOfSegments() {
        return segments.length;
    }

    /**
     * the line segments
     */
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}


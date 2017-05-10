/**
 * Author:     Christopher
 * Written:    2017/4/23
 * This program solve the problem: Given a set of n distinct points in the plane,
 * find every (maximal) line segment that connects a subset of 4 or more of the points.
 */
public class FastCollinearPoints {

    LineSegment[] segments;

    /** find all line segments containing 4 points */
    public FastCollinearPoints(Point[] points) {

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

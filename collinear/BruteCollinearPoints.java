/**
 * Author:     Christopher
 * Written:    2017/4/23
 */
public class BruteCollinearPoints {

    int count;
    Point[] points;

    /** find all line segments containing 4 points */
    public BruteCollinearPoints(Point[] points) {
        this.count = 0;
        this.points = points;
    }

    /** the number of line segments */
    public int numberOfSegments() {
        return count;
    }

    /** the line segments */
    public LineSegment[] segments() {
        return null;
    }

}

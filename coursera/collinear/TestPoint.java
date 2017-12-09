/**
 * Author:     Christopher
 * Written:    2017/4/23
 */

import org.junit.Test;

import java.security.PublicKey;
import java.util.Comparator;

import static org.junit.Assert.*;

public class TestPoint {
    @Test
    public void testSlopeTo() {
        Point origin = new Point(0, 0);
        Point a = new Point(3, 0);
        Point b = new Point(0, 2);

        assertEquals(origin.slopeTo(origin), Double.NEGATIVE_INFINITY, 0.0001);
        assertEquals(origin.slopeTo(a), 0.0, 0.0001);
        assertEquals(origin.slopeTo(b), Double.POSITIVE_INFINITY, 0.0001);
        double slopeAB = 2 / -3;
        assertEquals(a.slopeTo(b), slopeAB, 0.0001);

    }

    @Test
    public void testCompareTo() {
        Point origin = new Point(0, 0);
        Point a = new Point(3, 0);
        Point b = new Point(0, 2);

        assertEquals(origin.compareTo(origin), 0);
        assertEquals(origin.compareTo(b), -1);
        assertEquals(a.compareTo(origin), 1);
    }

    @Test
    public void testSlopeComparator() {
        Point origin = new Point(0, 0);
        Point a = new Point(3, 0);
        Point b = new Point(0, 2);
        Comparator<Point> pc = origin.slopeOrder();

        double slope1 = origin.slopeTo(a);
        double slope2 = origin.slopeTo(b);
        int exp = Double.compare(slope1, slope2);

        assertEquals(pc.compare(a, b), exp);

    }

}

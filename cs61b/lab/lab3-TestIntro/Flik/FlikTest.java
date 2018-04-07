/**
 * Created by Christopher on 2017/2/11.
 */

import org.junit.Test;

import static org.junit.Assert.*;


public class FlikTest {

    @Test
    public void testIsSameNumber() {
        int a = 128;
        int b = 128;

        assertTrue(Flik.isSameNumber(a, b));

    }
}

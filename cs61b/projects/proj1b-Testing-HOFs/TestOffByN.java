import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    @Test
    public void testOffByN() {
        OffByN byZero = new OffByN(0);
        assertTrue(byZero.equalChars('a', 'a'));

        OffByN byOne = new OffByN(1);
        assertTrue(byOne.equalChars('a', 'b'));
        assertTrue(byOne.equalChars('b', 'a'));

        OffByN byTwo = new OffByN(2);
        assertTrue(byTwo.equalChars('a', 'c'));
        assertTrue(byTwo.equalChars('c', 'a'));
    }
}
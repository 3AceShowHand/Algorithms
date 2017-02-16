import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Christopher on 2017/2/16.
 */

public class ArrayDequeTest {
    @Test
    public void ArraryDequeTest() {
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.addFirst("First");
        deque.addLast("Last");
        deque.addLast("Third");
        deque.addFirst("Second");
        String[] exp = new String[]{"Last", "Third", null, null, null, null, "Second", "First"};
        assertArrayEquals(exp, deque.getItems());
    }

    @Test
    public void removeTest() {
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.addFirst("First");
        deque.addLast("Last");
        deque.addLast("Third");
        deque.addFirst("Second");

        String removeFirstExp = "Second";
        String removeLastExp = "Third";

        assertEquals(removeFirstExp, deque.removeFirst());
        assertEquals(removeLastExp, deque.removeLast());
    }
}

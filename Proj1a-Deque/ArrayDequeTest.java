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

    @Test
    public void expandTest() {
        ArrayDeque<String> deque = new ArrayDeque<>(4);
        deque.addLast("First");
        deque.addLast("Second");
        deque.addFirst("Third");
        deque.addFirst("Forth");
        deque.expand();

        String[] exp = new String[]{"Forth", "Third", "First", "Second", null, null, null, null};

        assertArrayEquals(exp, deque.getItems());
    }

    @Test
    public void shrinkTest() {
//        ArrayDeque<String> deque = new ArrayDeque<>(8);
//        deque.addLast("First");
//        deque.addLast("Second");
//        deque.addLast("Third");
//        deque.removeLast();
//
//        String[] exp = new String[] {"First", "Second", null, null, null, null, null, null};
//        assertArrayEquals(exp, deque.getItems());

        ArrayDeque<String> deque1 = new ArrayDeque<>(16);
        deque1.addLast("First");
        deque1.addLast("Second");
        deque1.addLast("Third");
        deque1.addLast("Forth");
        deque1.removeFirst();

        String[] exp1 = new String[] { "Second", "Third", "Forth" };
        assertArrayEquals(exp1, deque1.getItems());
    }

}

package synthesizer;
import org.junit.Test;


import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {

    /** Test for enqueue and dequeue*/
    @Test
    public void testEnDe() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(5);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        assertEquals(3, arb.fillCount());
        assertEquals((Integer) 3, arb.dequeue());
        Integer x = arb.dequeue();
        assertEquals((Integer) 4, x);
        assertEquals(1, arb.fillCount());
    }


    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 

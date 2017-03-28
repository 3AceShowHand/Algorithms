/**
 * Created by Christopher on 2017/3/28.
 * Act as an ArrayDeque autograder.
 */

import static org.junit.Assert.*;
import org.junit.Test;


public class TestArrayDeque1B {

    @Test
    public void testAdd() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        OperationSequence ops = new OperationSequence();

        for(int i = 0; i < 10; i++) {
            Integer randomNumber = StdRandom.uniform(20);
            if (randomNumber.compareTo(10) < 0) {
                sad.addFirst(randomNumber);
                ads.addFirst(randomNumber);
                ops.addOperation(new DequeOperation("addFirst", randomNumber));
            } else {
                sad.addLast(randomNumber);
                ads.addLast(randomNumber);
                ops.addOperation(new DequeOperation("addLast", randomNumber));
            }
        }
        Integer item1 = sad.removeLast();
        Integer item2 = ads.removeLast();
        assertEquals(ops.toString(), item1, item2);
    }

}

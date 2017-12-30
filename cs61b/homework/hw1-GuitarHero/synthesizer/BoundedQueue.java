package synthesizer;

import java.util.Iterator;

/**
 * Created by Christopher on 2017/3/30.
 */
public interface BoundedQueue<Item> extends Iterable<Item> {
    //Return the size of the buffer
    int capacity();

    // Return number of items currently in the buffer
    int fillCount();

    //add item x to the end
    void enqueue(Item x);

    //delete and return item from the front
    Item dequeue();

    //return but not delete item from the front
    Item peek();

    //is the buffer empty
    default boolean isEmpty() {
        return 0 == fillCount();
    }

    //is the buffer full
    default boolean isFull() {
        return fillCount() == capacity();
    }

    Iterator<Item> iterator();
}

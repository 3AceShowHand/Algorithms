package synthesizer;

/**
 * Created by Christopher on 2017/3/30.
 */
public interface BoundedQueue<Item> {
    //Return the size of the buffer
    int capaticy();

    // Return number of items currently in the buffer
    int fillCount();

    //add item x to the end
    void enque(Item x);

    //delete and return item from the front
    Item deque();

    //return but not delete item from the front
    Item peek();

    //is the buffer empty
    default boolean isEmpty() {
        return 0 == fillCount();
    }

    //is the buffer full
    default boolean isFull() {
        return fillCount() == capaticy();
    }
}

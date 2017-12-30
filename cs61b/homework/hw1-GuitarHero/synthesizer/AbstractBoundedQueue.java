package synthesizer;

/**
 * Created by Christopher on 2017/3/30.
 */
public abstract class AbstractBoundedQueue<Item> implements BoundedQueue<Item> {

    protected int fillCount;
    protected int capacity;

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    @Override
    public abstract Item dequeue();

    @Override
    public abstract void enqueue(Item x);
}

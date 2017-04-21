import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    int count;

    public RandomizedQueue() {

    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void enqueue(Item item) {

    }

    public Item dequeue() {

    }

    public Item sample() {

    }

    public Iterator<Item> iterator() {
        return new RandomIter();
    }

    private class RandomIter implements Iterator<Item> {


    }

}
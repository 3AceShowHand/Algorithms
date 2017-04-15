import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private int count;
    private int front;
    private int rear;
    private int capacity;
    private Item[] items;

    public Deque(int cap) {
        count = front = rear = 0;
        capacity = cap;
        items = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void addFirst(Item item) {

    }

    public void addLast(Item item) {

    }

    private Item removeFirst() {

    }

    private Item removeLast() {

    }

    public Iterator<Item> iterator() {
        return new KeyIter();
    }

    private class KeyIter implements Iterator<Item> {
        @Override
        public boolean hasNext() {

        }

        @Override
        public Item next() {
            return null;
        }
    }


    public static void main(String[] args) {

    }

}

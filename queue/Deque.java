import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int count;
    // always point to the position of first item
    private int front;
    // always point to the position put the next item
    private int rear;
    private int capacity;
    private Item[] items;

    public Deque() {
        front = rear = count = 0;
        capacity = 4;
        items = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == capacity;
    }

    public int size() {
        return count;
    }

    private void expand() {

    }
    private void shrink() {

    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("Inserting a null item");
        }
        if (front == 0)
            front = capacity - 1;
        else
            front = front - 1;
        items[front] = item;
        count++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("Inserting a null item");
        }
        items[rear] = item;
        rear = (rear + 1) % capacity;
        count++;
    }

    private Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Cannot remove item from an empty deque");
        }
    }

    private Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Cannot remove item from an empty deque");
        }
        Item res =
    }

    public Iterator<Item> iterator() {
        return new KeyIter();
    }

    private class KeyIter implements Iterator<Item> {

        private int current = front;

        @Override
        public boolean hasNext() {
            return current != rear;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item res = items[current];
            current++;
            return res;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {

    }

}

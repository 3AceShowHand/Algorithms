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
        Item[] container = (Item[]) new Object[capacity*2];
        if (front < rear) {
            for (int idx = front; idx < rear; idx++){
                container[idx] = items[idx];
            }
        } else {
            for (int idx = front; front < capacity; front++){
                container[idx] = items[idx];
            }
            for (int idx = 0; idx < rear; idx++){
                container[idx] = items[idx];
            }
        }
        capacity *= 2;
        items = container;
    }

    private void shrink() {
        int size = (int) (capacity * 0.5);
        Item[] container = (Item[]) new Object[size];
        int curr = 0;
        if (front < rear) {
            for (int idx = front; idx < rear; idx++) {
                container[curr++] = items[idx];
            }
        } else {
            for (int idx = front; idx < capacity; idx++) {
                container[curr++] = items[idx];
            }
            for (int idx = 0; idx < rear; idx++) {
                container[curr++] = items[idx];
            }
        }

        capacity = size;
        items = container;
        front = 0;
        rear = curr;


    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("Inserting a null item");
        }
        if (isFull()) {
            expand();
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
        if (isFull()) {
            expand();
        }
        items[rear] = item;
        rear = (rear + 1) % capacity;
        count++;
    }

    private Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Cannot remove item from an empty deque");
        }

        Item res = items[front];
        items[front] = null;
        count--;
        if (front == capacity-1) {
            front = 0;
        } else {
            front += 1;
        }

        double loadFactor = (double) count / capacity;
        if (capacity > 8 && loadFactor < 0.25) {
            shrink();
        }

        return res;
    }

    private Item removeLast() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Cannot remove item from an empty deque");
        }
        if (rear == 0) {
            rear = capacity - 1;
        } else {
            rear -= 1;
        }
        Item res = items[rear];
        items[rear] = null;
        count--;

        double loadFactor = (double) count / capacity;
        if (capacity > 8 && loadFactor < 0.25) {
            shrink();
        }

        return res;
    }

    public Iterator<Item> iterator() {
        return new KeyIter();
    }

    private class KeyIter implements Iterator<Item> {

        private int current;

        private KeyIter() {
            current = front;
        }

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
            current = (current + 1) % capacity;
            return res;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

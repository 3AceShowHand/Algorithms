import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int count;
    private int front;
    private int rear;
    private int capacity;
    private Item[] items;

    public RandomizedQueue() {
        count = front = rear = 0;
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

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException("Enqueue a null item.");
        }
        if (isFull()) {
            expand();
        }
        items[rear++] = item;
        count++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty.");
        }
        int order = StdRandom.uniform(count);
        Item res = items[order];
        items[order] = items[--rear];
        items[rear] = null;
        count--;

        double loadFactor = (double) count / capacity;
        if (capacity > 8 && loadFactor < 0.25) {
            shrink();
        }

        return res;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty.");
        }
        int order = StdRandom.uniform(count);
        return items[order];
    }

    public Iterator<Item> iterator() {
        return new RandomIter();
    }

    private class RandomIter implements Iterator<Item> {

        private int idx;
        private int orders[];

        private RandomIter() {
            idx = front;
            orders = new int[count];
            for (int i = 0; i < orders.length; i++) {
                orders[i] = i;
            }
            StdRandom.shuffle(orders);
        }

        @Override
        public boolean hasNext() {
            return idx != rear;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[orders[idx++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
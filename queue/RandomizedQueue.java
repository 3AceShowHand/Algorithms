import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size;
    private Item[] items;

    public RandomizedQueue() {
        size = 0;
        items = (Item[]) new Object[4];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == items.length;
    }

    public int size() {
        return size;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty.");
        }
        int order = StdRandom.uniform(size);
        return items[order];
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty.");
        }

        int selected = StdRandom.uniform(size);
        Item res = items[selected];
        items[selected] = items[--size];
        items[size] = null;

        double loadFactor = size / (float) items.length;
        if (items.length > 8 && loadFactor < 0.25) {
            int newSize = items.length / 2;
            resize(newSize);
        }

        return res;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException("Enqueue a null item.");
        }
        if (isFull()) {
            resize(size*2);
        }

        items[size++] = item;
    }

    private void resize(int cap) {
        Item[] container = (Item[]) new Object[cap];
        for (int idx = 0; idx < size; idx++) {
            container[idx] = items[idx];
        }
        items = container;
    }

    public Iterator<Item> iterator() {
        return new RandomIter();
    }

    private class RandomIter implements Iterator<Item> {

        private int idx;
        private int[] orders;

        private RandomIter() {
            idx = 0;
            orders = new int[size];
            for (int i = 0; i < orders.length; i++) {
                orders[i] = i;
            }
            StdRandom.shuffle(orders);
        }

        @Override
        public boolean hasNext() {
            return idx != size;
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

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        for (int i = 0; i < 16; i++) {
            rq.enqueue(i);
        }
        while (!rq.isEmpty()) {
            rq.dequeue();
        }
    }
}
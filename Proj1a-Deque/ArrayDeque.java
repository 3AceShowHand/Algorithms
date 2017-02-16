import java.util.Objects;

/**
 * Created by Christopher on 2017/2/13.
 */
public class ArrayDeque<Item> implements Deque<Item> {

    private Item[] items;
    private int capacity;
    private int size;
    // front always point to the position of first element.
    private int front;
    // rear always point to the position of next element to insert.
    private int rear;

    private void init(int cap) {
        capacity = cap;
        size = front = rear = 0;
        items = (Item[]) new Object[capacity];
    }

    public ArrayDeque(int cap) {
        init(cap);
    }

    public ArrayDeque() {
        init(8);
    }

    public Item[] getItems() {
        return items;
    }


    public void expand(int factor) {
        int newCapacity = capacity * factor ;
        Item[] container = (Item[]) new Object[newCapacity];
        int idx = 0;

        for(int i = front; i < capacity; i++) {
            container[idx] = items[i];
            idx++;
        }
        for(int i = 0; i < rear; i++) {
            container[idx] = items[i];
            idx += 1;
        }

        capacity = newCapacity;
        front = 0;
        rear = idx;
        items = container;

    }

    public void shrink() {
        double loadFactor = (double)size / capacity;
        if (loadFactor < 0.25 && capacity > 8) {
            final double shrinkFactor = 0.5;
            int newCapacity = (int)(shrinkFactor * capacity);
            Item[] container = (Item[]) new Object[newCapacity];
            int idx = 0;

            if(front > rear) {
                for (int i = front; i < capacity; i++) {

                }
            }

        }
    }

    @Override
    public int size() {
        return size;
}

    private boolean isFull() {
        return size == capacity;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(Item item) {
        if (isFull()) {
            expand();
        }

        if (front == 0) {
            front = capacity - 1;
        }
        else {
            front = front - 1;
        }
        items[front] = item;
        size++;
    }

    @Override
    public void addLast(Item item) {
        if (isFull()) {
            expand();
        }
        items[rear] = item;
        rear = (rear + 1) % capacity;
        size++;
    }

    @Override
    public Item removeFirst() {
        Item res = items[front];
        items[front] = null;
        size--;
        if (front == (capacity-1)) {
            front = 0;
        } else {
            front += 1;
        }

        shrink();
        return res;
    }

    @Override
    public Item removeLast() {
        if (rear == 0) {
            rear = capacity - 1;
        } else {
            rear = rear - 1;
        }
        Item res = items[rear];
        items[rear] = null;
        size--;

        shrink();
        return res;
    }

    @Override
    public void printDeque() {
        if (front <= rear) {
            for( int i = front; i < rear; i++) {
                System.out.print(items[i] + " ");
            }
        } else {
            for( int i = front; i < capacity; i++) {
                System.out.print(items[i] + " ");
            }
            for(int i = 0; i < rear; i++) {
                System.out.print(items[i] + " ");
            }
        }
    }

    

    @Override
    public Item get(int index) {
        return null;
    }
}

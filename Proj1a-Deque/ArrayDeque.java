import java.util.Objects;

/**
 * Created by Christopher on 2017/2/13.
 */
public class ArrayDeque<Item> implements Deque<Item> {

    private Item[] items;
    private int capacity;
    private int size;
    // head always point to the position of first element.
    private int head;
    // tail always point to the position of next element to insert.
    private int tail;


    public ArrayDeque() {
        capacity = 8;
        size = head = tail = 0;
        items = (Item[]) new Object[capacity];
    }

    public Item[] getItems() {
        return items;
    }

    @Override
    public int size() {
        return size;
}

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(Item item) {
        if (head == 0) {
            head = capacity - 1;
        }
        else {
            head = head - 1;
        }
        items[head] = item;
        size++;
    }

    @Override
    public void addLast(Item item) {
        items[tail] = item;
        tail = (tail + 1) % capacity;
        size++;
    }

    @Override
    public void printDeque() {
        if (head <= tail) {
            for( int i = head; i < tail; i++) {
                System.out.print(items[i] + " ");
            }
        } else {
            for( int i = head; i < capacity; i++) {
                System.out.print(items[i] + " ");
            }
            for(int i = 0; i < tail; i++) {
                System.out.print(items[i] + " ");
            }
        }
    }

    @Override
    public Item removeFirst() {
        Item res = items[head];
        items[head] = null;
        if (head == (capacity-1)) {
            head = 0;
        } else {
            head += 1;
        }
        return res;
    }

    @Override
    public Item removeLast() {
        if (tail == 0) {
            tail = capacity - 1;
        } else {
            tail = tail - 1;
        }
        Item res = items[tail];
        items[tail] = null;
        return res;
    }

    @Override
    public Item get(int index) {
        return null;
    }
}

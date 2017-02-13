import java.util.Objects;

/**
 * Created by Christopher on 2017/2/13.
 */
public class ArraryDeque<Item> implements Deque<Item> {

    private Item items;
    private int size;

    public ArraryDeque() {
        items = (Item[]) new Object[4];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void addFirst(Item item) {

    }

    @Override
    public void addLast(Item item) {

    }

    @Override
    public void printDeque() {

    }

    @Override
    public Item removeFirst() {

    }

    @Override
    public Item removeLast() {

    }

    @Override
    public Item get(int index) {

    }
}

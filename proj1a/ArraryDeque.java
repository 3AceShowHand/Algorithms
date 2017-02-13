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

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}

/**
 * Created by Christopher on 2017/2/13.
 */
public class LinkedListDeque<Item> implements Deque<Item> {

    private class Node<Item> {
        public Item value;
        public Node next;

        public Node(Item item, Node n) {
            value = item;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = null;
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
        for(Node ptr = sentinel.next; ptr != null; ptr = ptr.next) {
            System.out.println(ptr.value + " ");
        }
    }

    @Override
    public Item removeFirst() {

    }

    @Override
    public Item removeLast() {

    }

    @Override
    public Item get(int index) {
        Node ptr = sentinel.next;
        while (index != 0) {
            ptr = ptr.next;
        }
        return ptr.value;
    }

}

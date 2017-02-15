/**
 * Created by Christopher on 2017/2/13.
 */
public class LinkedListDeque<Item> implements Deque<Item> {

    private class Node<Item> {
        public Item value;
        public Node prev;
        public Node next;

        Node(Item item) {
            value = item;
        }

        Node() {
            value = null;
            prev = null;
            next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedListDeque() {
        front = new Node();
        rear = new Node();
        front.next = rear;
        rear.prev = front;
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
        Node n = new Node(item);
        n.prev = front;
        n.next = front.next;
        n.next.prev = n;
        front.next = n;
        size += 1;
    }

    @Override
    public void addLast(Item item) {
        Node n = new Node(item);
        n.next = rear;
        n.prev = rear.prev;
        rear.prev.next = n;
        rear.prev = n;
        size += 1;
    }

    @Override
    public void printDeque() {
        for (Node ptr = front.next; ptr != rear; ptr = ptr.next) {
            System.out.print(ptr.value + " ");
        }
    }

    @Override
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node first = front.next;
        Item res = (Item) first.value;
        front.next = first.next;
        first.next.prev = front;
        first.value = first.prev = first.next = null;
        size--;
        return res;
    }

    @Override
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node last = rear.prev;
        Item res = (Item) last.value;
        rear.prev = last.prev;
        last.prev.next = rear;
        last.value = last.prev = last.next = null;
        size--;
        return res;
    }

    /**Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     */
    @Override
    public Item get(int index) {
        Node ptr = front;
        while (index != 0) {
            ptr = ptr.next;
            index -= 1;
        }
        return (Item) ptr.value;
    }

    private Item getRecursive(int index, Node p) {
        if (index == 0) {
            return (Item) p.value;
        }
        return getRecursive(index-1, p.next);
    }

    public Item getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }
        return getRecursive(index, front);
    }

}

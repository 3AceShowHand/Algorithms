public class DLList<T> {
    private class Node {
        public Node prev;
        public T item;
        public Node next;
    }

    private Node fontSentinel;
    private Node backSentinel;

    public DLList() {
        frontSentinel.next = backSentinel;
        backSentinel.prev = frontSentinel;
    }

}
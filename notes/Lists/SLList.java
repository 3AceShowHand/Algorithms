public class SLList {

    /** If the nested class never uses any instance variables or methods of the out class, declare it static
     * Private variables and methods can only be accessed by code in the same .java file.
     * static classes cannot access outer class's instance variables or methods.
     * Results in a minor savings of memory.
    */
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i , IntNode n) {
            item = i;
            next = n;
        }
    }

    /**The first item (if it exists) is at sentinel.next */
    private IntNode sentinel;
    private int size;

    public SLList(){
        size = 0;
        sentinel = new IntNode(size, null);
        
    }

    public SLList(int x) {
        size = 1;
        sentinel = new IntNode(size, null);
        sentinel.next = new IntNode(x, null);
    }

    /** Add x to the front of the list*/
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Return the first item in the list. */
    public int getFirst() {
        return sentinel.next.item;
    }


    public void addLast(int x) {
        size = size + 1;
        IntNode p = sentinel;
        while(p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }


    private static int size(IntNode p){
        if (p.next == null) {
            return 1;
        }
        return 1 + size(p.next);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        L.addFirst(20);

        System.out.println(L.size());
    }

}
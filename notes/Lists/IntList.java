public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList L) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.reset.size();
    }

    public int IterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /**Returns the ith item of IntList */
    public int get(int i){
        if (i == 0) {
            return first;
        }
        return this.rest.get(i -1);
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, null);
        L = new IntList(5, null);
    }
    
}
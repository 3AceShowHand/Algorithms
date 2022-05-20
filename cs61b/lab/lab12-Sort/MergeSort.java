import edu.princeton.cs.algs4.Queue;

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     *
     * The method assumes that both q1 and q2 are in sorted order, with the smallest
     * item first. At most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param q1 A Queue in sorted order from least to greatest.
     * @param q2 A Queue in sorted order from least to greatest.
     * @return The smallest item that is in q1 or q2.
     */
    private static <Item extends Comparable> Item getMin(Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /** Returns a queue of queues that each contain one item from items. */
    private static <Item extends Comparable> Queue<Queue<Item>> makeSingleItemQueues(Queue<Item> items) {
        // Your code here!
        Queue<Queue<Item>> ret = new Queue<>();
        for (Item c: items) {
            Queue<Item> x = new Queue<>();
            x.enqueue(c);
            ret.enqueue(x);
        }
        return ret;
    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     *
     * This method should take time linear in the total number of items in q1 and
     * q2. After running this method, q1 and q2 will be empty, and all of their
     * items will be in the returned queue.
     *
     * @param q1 A Queue in sorted order from least to greatest.
     * @param q2 A Queue in sorted order from least to greatest.
     * @return A Queue containing all of the q1 and q2 in sorted order, from least
     *         to greatest.
     *
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(Queue<Item> q1, Queue<Item> q2) {
        // Your code here!
        Queue<Item> ret = new Queue<>();
        while (!(q1.isEmpty() && q2.isEmpty())) {
            ret.enqueue(getMin(q1, q2));
        }
        return ret;
    }

    /**
     * Returns a Queue that contains the given items sorted from least to greatest.
     */
    public static <Item extends Comparable> Queue<Item> mergeSort(Queue<Item> items) {
        // Your code here
        Queue<Queue<Item>> qs = makeSingleItemQueues(items);
        while (qs.size() > 1) {
            Queue<Item> a = qs.dequeue();
            Queue<Item> b = qs.dequeue();
            qs.enqueue(mergeSortedQueues(a,  b));
        }
        return qs.dequeue();
    }

    public static void main(String[] args) {
        Queue<String> students = new Queue<>();
        students.enqueue("YaqiangWu");
        students.enqueue("JieLiu");
        students.enqueue("LingJin");
        students.enqueue("HoushengWei");
        students.enqueue("LeiWan");
        students.enqueue("HaoLiu");
        students.enqueue("PanYao");
        students.enqueue("YanbingLi");
        students.enqueue("XinAi");
        students.enqueue("ShanshanChen");
        students.enqueue("ChuyuePeng");
        System.out.println(students);


        Queue<String> sorted =  MergeSort.mergeSort(students);
        System.out.println(students);
        System.out.println(sorted);
    }
}
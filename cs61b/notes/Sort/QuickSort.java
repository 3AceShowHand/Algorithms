public class QuickSort {
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi;
        while(true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) break;
            }
            while (less(a[lo], a[--j])) {
                if (j == lo) break;
            }

            if (i >= j) break;
            exch(a, i, j);
    }

    exch(a, lo, j);
    return j;    
    }

    public static void sort(Comparable[] a) {
    	StdRandom.shuffle(a);
	sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
    	if (hi <= lo) return;
	    int j = partition(a, lo, hi);
	    sort(a, lo, j - 1);
	    sort(a, j + 1, hi);
    }

    public static Comparable select(Comparable[] a, int k) {
    	StdRandom.shuffle(a);
	    int lo = 0, hi = a.length - 1;

	    while (hi > lo) {
		    int j = partition(a, lo, hi);
		    if (j < k) lo = j + 1;
		    else if (j > k) hi = j - 1;
		    else return a[k];
	    }
	reurn a[k];

    }

}

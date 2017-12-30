package synthesizer;

//Make sure this class is public
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        //       cast the result of this divsion operation into an int. For better
        //       accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.
        int capacity = (int) Math.round((SR / frequency));
        buffer = new ArrayRingBuffer<>(capacity);
        while (!buffer.isFull()) {
            buffer.enqueue(0.0);
        }
    }

    public static boolean inArray(Double[] arr, Double x) {
        for (int i = 0; i < arr.length; i++) {
            if (x.equals(arr[i])) {
                return true;
            }
        }
        return false;

    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each other.
        Double[] arr = new Double[buffer.capacity()];
        for (int idx = 0; idx < arr.length; idx++) {
            Double r = Math.random() - 0.5;
            if (idx == 0) {
                arr[idx] = r;
            } else {
                while (inArray(arr, r)) {
                    r = Math.random() - 0.5;
                }
                arr[idx] = r;
            }
        }
        for (int idx = 0; idx < arr.length; idx++) {
            buffer.dequeue();
            buffer.enqueue(arr[idx]);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
        double avg = DECAY * 0.5 * (buffer.dequeue() + buffer.peek());
        buffer.enqueue(avg);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
}

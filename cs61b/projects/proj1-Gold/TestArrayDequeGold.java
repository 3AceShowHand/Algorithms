import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testRandomMethod() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            double r = StdRandom.uniform();
            if (r < 0.5) {
                int number = StdRandom.uniform(10000);
                if (StdRandom.uniform() < 0.5) {
                    sad.addFirst(number);
                    ads.addFirst(number);
                    String command = String.format("addFirst(%s)\n", number);
                    sb.append(command);
                } else {
                    sad.addLast(number);
                    ads.addLast(number);
                    String command = String.format("addLast(%s)\n", number);
                    sb.append(command);
                }

            } else {
                if ((!sad.isEmpty()) && (!ads.isEmpty())) {
                    if(StdRandom.uniform() < 0.5) {
                        int x = sad.removeFirst();
                        int y = ads.removeFirst();
                        sb.append("removeFirst()\n");
                        assertEquals(sb.toString(), x, y);
                    } else {
                        int x = sad.removeLast();
                        int y = ads.removeLast();
                        sb.append("removeLast()\n");
                        assertEquals(sb.toString(), x, y);
                    }
                }
            }
        }
    }
}

public class HorribleSteve {
	public static void main (String [] args) {
		int j = 0;
        int i;
        for(i = 0; i < 500; i++, j++) {
            if (!Flik.isSameNumber(i, j)) {
                break;
            }
        }
		System.out.println("i is " + i);
	}
} 
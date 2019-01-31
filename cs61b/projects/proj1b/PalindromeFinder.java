/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("words.txt");
        Palindrome palindrome = new Palindrome();

        System.out.println("Common Palindromes:");
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }

        System.out.println("Palindromes with OffByOne:");
        OffByOne obo = new OffByOne();
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, obo)) {
                System.out.println(word);
            }
        }
    }
}

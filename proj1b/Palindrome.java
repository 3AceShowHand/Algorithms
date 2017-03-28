/**
 * Created by Christopher on 2017/3/28.
 */
public class Palindrome {

    public static Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> res = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public static boolean isPalindrome(String word) {
        int low = 0, high = word.length() - 1;
        while (low < high) {
            if (word.charAt(low) != word.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        int low = 0, high = word.length() - 1;
        while (low < high) {
            if(!cc.equalChars(word.charAt(low), word.charAt(high)))
                return false;
            low++;
            high--;
        }
        return true;
    }
}

/**
 * Created by Christopher on 2017/3/28.
 */

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }
    public boolean isPalindrome(String word) {
        Deque<Character> deq = wordToDeque(word);
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != deq.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deq = wordToDeque(word);
        for (int i = 0; i < word.length() / 2; i++) {
            if (!cc.equalChars(word.charAt(i), deq.removeLast())) {
                return false;
            }
        }
        return true;
    }

}
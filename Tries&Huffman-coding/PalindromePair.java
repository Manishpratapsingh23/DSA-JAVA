
import java.util.ArrayList;

public class PalindromePair {
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindromePair(ArrayList<String> words) {
        // Insert all words into the Trie
        Trie tt=new Trie();
        for (String word : words) {
            tt.add(word);
        }

        // Check for palindrome pairs
        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();

            // Case 1: Check if the reverse of the word exists in the Trie
            if (tt.search(reversed)) {
                return true;
            }

            // Case 2: Check if any prefix of the word is a palindrome and the rest exists
            for (int i = 1; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);

                if (isPalindrome(prefix) && tt.search(new StringBuilder(suffix).reverse().toString())) {
                    return true;
                }

                if (isPalindrome(suffix) && tt.search(new StringBuilder(prefix).reverse().toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}

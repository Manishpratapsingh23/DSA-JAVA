import java.util.ArrayList;

public class PalindromePairUse {
    public static void main(String[] args) {
        ArrayList<String> words1= new ArrayList<>();
        words1.add("abc");
        words1.add("def");
        words1.add("ghi");
        words1.add("cba");

        ArrayList<String> words2= new ArrayList<>();
        words2.add("abc");
        words2.add("def");

        ArrayList<String> words = new ArrayList<>();
        words.add("race");
        words.add("car");
        words.add("bat");
        words.add("tab");
        PalindromePair pp=new PalindromePair();
        System.out.println(pp.isPalindromePair(words1));
        System.out.println(pp.isPalindromePair(words2));
        System.out.println(pp.isPalindromePair(words));

    }
}

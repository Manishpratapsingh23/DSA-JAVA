import java.util.ArrayList;
import java.util.List;

public class leetcode_30 {
    private static List<String> permutation(String input[], String output) {
        List<String> ans_lst = new ArrayList<>();
        if (input.length == 0) {
            ans_lst.add(output);
            return ans_lst;
        }

        for (int i = 0; i < input.length; i++) {
            String st = input[i];
            String ans[] = new String[input.length - 1];
            int k = 0;
            for (int j = 0; j < input.length; j++) {
                if (i != j)
                    ans[k++] = input[j];
            }
            List<String> recursive_lst = (permutation(ans, output + st));
            ans_lst.addAll(recursive_lst);
        }
        return ans_lst;
    }

    public static List<Integer> findindex(String s, List<String> lst) {

        List<Integer> result = new ArrayList<>();
        for (String st : lst) {
            int l = st.length();
            for (int i = 0; i <= s.length() - l; i++) {
                if (s.substring(i, i + l).equals(st) && !result.contains(i)) {
                    result.add(i);
                }
            }
        }
        return result;

    }

    public static void main(String agrs[]) {
        String s = "barfoofoobarthefoobarman";
        String arr[] = { "bar", "foo", "the" };
        String s1 = "wordgoodgoodgoodbestword";
        String arr1[] = { "word", "good", "best", "good" };
        String s2 = "fffffffffffffffffffffffffffffffff";
        String arr2[] = {"a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"};
        List<String> lst = permutation(arr, "");
        System.out.println(findindex(s, lst));
        List<String> lst1 = permutation(arr1, "");
        System.out.println(findindex(s1, lst1));
        List<String> lst2 = permutation(arr2, "");
        System.out.println(findindex(s2, lst2));

    }
}
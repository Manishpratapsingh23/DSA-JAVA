import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String st : words){
            map.put(st,-1);
        }
        int wordLength = words[0].length();
        for(int i=0;i+wordLength<s.length();i++){
            String st = s.substring(i, i+wordLength);
            if( map.containsKey(st) && map.get(st)==-1) map.put(st,i);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String agrs[]) {
        String s = "barfoofoobarthefoobarman";
        String arr[] = { "bar", "foo", "the" };
        String s1 = "wordgoodgoodgoodbestword";
        String arr1[] = { "word", "good", "best", "good" };
        String s2 = "fffffffffffffffffffffffffffffffff";
        String arr2[] = {"a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a"};
        System.out.println(new leetcode_30().findSubstring(s, arr));
        System.out.println(new leetcode_30().findSubstring(s1, arr1));      
        System.out.println(new leetcode_30().findSubstring(s2, arr2));
        System.out.println(new leetcode_30().findSubstring("a", new String[]{"a"}));
        System.out.println(new leetcode_30().findSubstring("a", new String[]{"b"}));
        System.out.println(new leetcode_30().findSubstring("a", new String[]{}));
        System.out.println(new leetcode_30().findSubstring("a", new String[]{"a","b"}));
        System.out.println(new leetcode_30().findSubstring("a", new String[]{"a","b","c"}));
        System.out.println(new leetcode_30().findSubstring("a", new String[]{"a","b","c","d"}));

    }
}
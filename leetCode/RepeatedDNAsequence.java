import java.util.*;
public class RepeatedDNAsequence{
    public static void main(String[] args) {
        String dna = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        for(String s : solve(dna)) System.out.println(s+" ");
    }


    private static List<String> solve(String dna){
        int left=0,right=0;
        Map<String, Integer> map = new HashMap<>();
        while(right<dna.length()){
            if(right-left+1>=10){
                map.put(dna.substring(left,right+1),map.getOrDefault(dna.substring(left,right+1), 0)+1);
                left++;
            }
            right++;
        }
        List<String> lst = new ArrayList<>();
        for(String s : map.keySet()){
            if(map.get(s)>1) lst.add(s);
        }
        return lst;
    }
}
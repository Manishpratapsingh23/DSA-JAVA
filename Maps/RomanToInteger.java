import java.util.HashMap;
public class RomanToInteger {
    private static int conversion(String roman){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("M",1000);
        map.put("CM",900);
        map.put("D",500);
        map.put("CD",400);
        map.put("C",100);
        map.put("XC",90);
        map.put("L",50);
        map.put("XL",40);
        map.put("X",10);
        map.put("IX",9);
        map.put("V",5);
        map.put("IV",4);
        map.put("I",1);
        int ans=0;
        int i = 0, l = roman.length();
        while (i < l) {
            if (i + 1 < l && map.containsKey(roman.substring(i, i + 2))) {
                ans += map.get(roman.substring(i, i + 2));
                i += 2;
            } else {
                ans += map.get(roman.substring(i, i + 1));
                i += 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String roman[]={"LVIII","MMMDCCXLIX","III","MCMXCIV"}; // 58,3749,3,1994
        //String roman="MMMDCCXLIX";
        //String roman="LVIII";
        for(String romans:roman){
            int ans=conversion(romans);
        System.out.println(ans);
        }
    }
}

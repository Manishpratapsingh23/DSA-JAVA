import java.util.*;
public class WK451_d {
     public static String lexicographicallySmallestString(String s) {
        StringBuilder st = new StringBuilder();
        int large = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>s.charAt(large)) large = i;
            if(st.length()>1 && isConsecutive(st.charAt(st.length()-1), ch)){
                st.append(ch);
            }
            else{
                    
            }
        }
     }

     private static boolean isConsecutive(char s, char c){
        int diff = Math.abs(s-c);
        return diff==1 || diff==25;
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(lexicographicallySmallestString(s));
     }
}

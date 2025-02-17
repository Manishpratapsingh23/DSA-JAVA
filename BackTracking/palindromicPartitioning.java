
import java.util.ArrayList;

public class palindromicPartitioning {
    public static ArrayList<ArrayList<String>> partition(String s){
        ArrayList<ArrayList<String>> output=new ArrayList<>();
        int l=s.length();
        if(l==0)
        return output;
        return partitionHelper(s,l,1,output);
    }
    public  static ArrayList<ArrayList<String>> partitionHelper(String s, int l, int end ,ArrayList<ArrayList<String>> output){
        ArrayList<String> lst=new ArrayList<>();
        if(checkPalindrome(s.substring(0,end))){
            
        }
        return output;
    }
    private static boolean checkPalindrome(String s){
        int si=0;
        int ei=s.length()-1;
        while(si<ei){
            if(s.charAt(si)!=s.charAt(ei)) return false;
            si++;
            ei--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s="aab";
        ArrayList<ArrayList<String>> ans=partition(s);
        for(ArrayList<String> lst : ans){
            for(String st:lst){
                System.out.print(st+" ");
            }
            System.out.println();
        }
    }
}

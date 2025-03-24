
import java.util.Arrays;

public class validParenthesisString {
    public static boolean checkValidString(String s) {
        int l=s.length();
        return helper(s,0,0);
    }
    private static boolean helper(String s, int index, int count){
        if(index==s.length()) return count==0;

        boolean isValid=false;
        if(s.charAt(index)=='('){
            isValid=helper(s, index+1, count+1);
        }
        else if(s.charAt(index)==')'){
            if(count>0){
                isValid=helper(s, index+1, count-1);
            }
        }
        else{
            isValid=helper(s, index+1, count+1) || helper(s, index+1, count-1) || helper(s, index+1, count);
        }
        

        return isValid;
    }

    public static boolean checkValidStringM(String s) {

        int l=s.length();
        boolean memo[][]=new boolean[l][l];
        for(boolean arr[] : memo) Arrays.fill(arr,false);
        return helperM(s,0,0,memo);

    }

    private static boolean helperM(String s, int index, int count, boolean memo[][]){
        if(index==s.length()) return count==0 ? true:false;
        if(count<0) return false;
        if(memo[index][count]!=false) return true;

        if(s.charAt(index)=='('){
            memo[index][count]=helperM(s, index+1, count+1,memo);
        }
        else if(s.charAt(index)==')'){
                memo[index][count]=(count>0) && helperM(s, index+1, count-1,memo);
        }
        else{
            memo[index][count]=helperM(s, index+1, count+1,memo) || helperM(s, index+1, count-1,memo) || helperM(s, index+1, count,memo);
        }
        return memo[index][count];
    }
    public static void main(String[] args) {
        String st="(()))";
        String s="(*))";
        System.out.println(checkValidString(st));
        System.out.println(checkValidStringM(st));
    }
}

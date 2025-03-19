
import java.util.Arrays;

public class leetcode_91 {
    public static int numDecodings(String s) {
        return helper(s,0);
    }
    private static int helper(String s, int index){
        if(index>=s.length()) return 1;
        if(s.charAt(index)=='0') return 0;
        int op2=0;
        int op1=helper(s, index+1);
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            op2 = helper(s, index + 2);
        }
        return op1+op2;
    }
    public static int numDecodingsM(String s) {
        int memo[]=new int[s.length()+1];
        Arrays.fill(memo,-1);
        return helperM(s,0,memo);
    }
    private static int helperM(String s, int index, int memo[]){
        if(index>=s.length()) return 1;

        if(s.charAt(index)=='0') return 0;

        if(memo[index]!=-1) return memo[index];

        int op1=helperM(s, index+1, memo);
        int op2=0;
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            op2 = helperM(s, index + 2, memo);
        }
        memo[index]=op1+op2;
        return memo[index];
    }

    public static int numDecodings_DP(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int memo[]=new int[s.length()+1];
        memo[0]=1;
        memo[1]= s.charAt(0)!='0' ? 1 : 0;
        int l=s.length();
        if(s.charAt(l-1)=='0') return 0;
        for(int i=2;i<=l;i++){
            int op1=Integer.parseInt(s.substring(i-1, i));
            int op2=Integer.parseInt(s.substring(i-2, i));
            if(op1>=1) memo[i]+=memo[i-1];
            if(op2>=10 && op2<=26) memo[i]+=memo[i-2];
        }
        return memo[l];
    }
    // public static int numDecodings_DP(String s) {
    //     if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
    //     int memo[]=new int[s.length()+1];
    //     Arrays.fill(memo,-1);
    //     memo[0]=1;
    //     memo[1]=s.charAt(0)!='0' ? 1 : 0;
    //     int l=s.length();
    //     if(s.charAt(l-1)=='0') return 0;
    //     for(int i=2;i<=l;i++){
    //         if(s.charAt(l-i)!='0'){
    //             memo[i]=memo[i-1]+memo[i-2];
    //         }
    //         else return 0;
    //     }
    //     return memo[l];
    // }

    public static void main(String[] args) {
        String s="11111";
        String s1="22206";
        String s2="226";
        System.out.println(numDecodings(s));
        System.out.println(numDecodingsM(s));
        System.out.println(numDecodings_DP(s));
        System.out.println(numDecodings(s1));
        System.out.println(numDecodingsM(s1));
        System.out.println(numDecodings_DP(s1));
        System.out.println(numDecodings(s2));
        System.out.println(numDecodingsM(s2));
        System.out.println(numDecodings_DP(s2));
    }
}

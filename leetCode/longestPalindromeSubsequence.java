
import java.util.Arrays;

public class longestPalindromeSubsequence {
    public static int longestPalindromeSubseq(String s) {
        return helper(s,0,"");
    }
    private static int helper(String s,int index, String output){
        if(index==s.length()){
            if(check(output)) return output.length();
            else return 0;
        }
        int op1=helper(s, index+1, output+s.charAt(index));
        int op2=helper(s, index+1, output);
        return Math.max(op1, op2);
    
    }
    private static boolean check(String st){
        int s=0,e=st.length()-1;
        while(s<=e){
            if(st.charAt(s)!=st.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }

    public static int longestPalindromeSubseqM(String s) {
        int l=s.length();
        int memo[][]=new int[l][l];
        for(int arr[] : memo) Arrays.fill(arr,-1);
        return helperM(s,0,l-1,memo);
    }

    private static int helperM(String s, int left, int right, int memo[][]){
        if(left>right) return 0;
        if(left==right) return 1;
        if(memo[left][right]!=-1) return memo[left][right];

        if(s.charAt(left)==s.charAt(right)){
            memo[left][right]=2+helperM(s, left+1, right-1, memo);
        }
        else{
            memo[left][right]=Math.max(helperM(s, left+1, right, memo),helperM(s, left, right-1, memo));
        }

        return memo[left][right];
    }
    
    public static int longestPalindromeSubseq_DP(String s) {
        int l=s.length();
        int dp[][]=new int[l][l];

        for(int i=0;i<l;i++) dp[i][i]=1;

        for(int len=2;len<=l;len++){
            for(int i=0;i<=l-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=2+dp[i+1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][l-1];
    }
    public static void main(String[] args) {
        String st="bbbcb";
        System.out.println(longestPalindromeSubseq_DP(st));
        System.out.println(longestPalindromeSubseq(st));
        System.out.println(longestPalindromeSubseqM(st));
    }
}

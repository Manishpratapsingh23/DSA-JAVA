    
import java.util.Arrays;

/*
 * Problem statement
Given two strings, 'S' and 'T' with lengths 'M' and 'N', 
find the length of the 'Longest Common Subsequence'.

For a string 'str'(per se) of length K, 
the subsequences are the strings containing characters in the same relative order as they are present in 'str,' 
but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.

Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
adebc
dcadb
Sample Output 1 :
3
Explanation of the Sample Output 1 :
Both the strings contain a common subsequence 'adb', 
which is the longest common subsequence with length 3. 
Sample Input 2 :
ab
defg
Sample Output 2 :
0
Explanation of the Sample Output 2 :
The only subsequence that is common to both the given strings is an empty string("") of length 0.
 */
public class longestCommonSubstring {
    public static int lcs(String s, String t) {
		//Your code goes here
        int sl=s.length();
        int tl=t.length();
        if(sl==0 || tl==0) return 0;
        if(s.charAt(0)==t.charAt(0)){
            return 1+lcs(s.substring(1), t.substring(1));
        }
        else{
            int op1=lcs(s.substring(1), t);
            int op2=lcs(s, t.substring(1));
            int op3=lcs(s.substring(1), t.substring(1));
            return Math.max(op1,Math.max(op2,op3));
        }
    }
    
    public static int lcsM(String s, String t){
        int memo[][]=new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++) Arrays.fill(memo[i],-1);
        return lcsM(s,t,memo);
    }

    private static int lcsM(String s, String t, int memo[][]){
        int m=s.length();
        int n=t.length();

        if(memo[m][n]!=-1) return memo[m][n];

        if(m==0 || n==0){
            memo[m][n]=0;
            return memo[m][n];
        }

        if(s.charAt(0)==t.charAt(0)){
            memo[m][n]=1+lcsM(s.substring(1), t.substring(1),memo);
        }
        else{
            int op1=lcsM(s.substring(1), t,memo);
            int op2=lcsM(s, t.substring(1),memo);
            memo[m][n]=Math.max(op1,op2);
        }
        return memo[m][n];   
    }

    public static int lcs_DP(String s, String t){
        int m=s.length();
        int n=t.length();
        int memo[][]=new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++) Arrays.fill(memo[i],-1);
        for(int i=0;i<=m;i++) memo[i][0]=0;
        for(int j=0;j<=n;j++) memo[0][j]=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(m-i)==t.charAt(n-j)){
                    memo[i][j]=1+memo[i-1][j-1];
                }
                else{
                    memo[i][j]=Math.max(memo[i-1][j],memo[i][j-1]);
                }
            }
        }
        return memo[m][n];
    }

    public static void main(String[] args) {
        String s="adgeidgeieidgeieidgeieidgeieidgei";
        String t="dcadbdgeibdgeibdgei";
        String s1="adef";
        String t1="deaf";
        System.out.println(lcs(s1, t1));
        System.out.println(lcsM(s,t));
        System.out.println(lcs_DP(s,t));
    }
}

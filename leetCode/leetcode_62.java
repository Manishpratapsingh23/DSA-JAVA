
import java.util.Arrays;

public class leetcode_62 {
    public static int uniquePaths(int m, int n) {
        int memo[][]=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(memo[i],-1);
        return helper(0,0,memo);
    }
    private static int helper(int i, int j, int memo[][]){
        int m=memo.length;
        int n=memo[0].length;
        if(m-1==i && n-1==j){
            memo[i][j]=1;
            return 1;
        }
        if(i>=m || j>=n ) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        int op1=helper(i+1,j,memo);
        int op2=helper(i,j+1,memo);
        memo[i][j]=op1+op2;
        return memo[i][j];
    }
    public static void main(String[] args) {
        int m=3;
        int n=7;
        System.out.println(uniquePaths(m, n));
    }
}

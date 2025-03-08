
import java.util.Arrays;

public class leetcode_63 {
    public static int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int memo[][]=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(memo[i],-1);
        return helper(grid,0,0,memo);
    }
    private static int helper(int grid[][], int i, int j, int memo[][]){
        int m=grid.length;
        int n=grid[0].length;
        if(m-1==i && n-1==j){
            memo[i][j]=1;
            return 1;
        }
        if(i>=m || j>=n ) return 0;
        if(grid[i][j]==1) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        int op1=helper(grid,i+1,j,memo);
        int op2=helper(grid,i,j+1,memo);
        memo[i][j]=op1+op2;
        return memo[i][j];
    }
    
    public static int uniquePathsWithObstacles_DP(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[m-1][n-1]==1) return 0;
        int memo[][]=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(memo[i],-1);
        //memo[m-1][n-1]=1;
        boolean check=true;
        for(int i=m-1;i>=0;i--){
            if(check && grid[i][n-1]==0){
                memo[i][n-1]=1;
            }
            else{
                check=false;
                memo[i][n-1]=0;
            }
        }
        check=true;
        for(int j=n-1;j>=0;j--){
            if(check && grid[m-1][j]==0){
                memo[m-1][j]=1;
            }
            else{
                check=false;
                memo[m-1][j]=0;
            }
        } 

        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
               if(grid[i][j]==1) memo[i][j]=0;
               else  memo[i][j]=memo[i+1][j]+memo[i][j+1];
            }
        }
        return memo[0][0];
    }

    public static int uniquePathsWithObstacles_DP1(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1]==1) return 0;
        int[] dp = new int[n]; 
        dp[n-1] = 1;
        for(int j=n-2;j>=0;j--){
            dp[j] = (grid[m-1][j] == 1) ? 0 : dp[j+1];
        } 

        for (int i = m - 2; i >= 0; i--) {
            dp[n-1] = (grid[i][n-1] == 1) ? 0 : dp[n-1]; // Last column update
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = (grid[i][j] == 1) ? 0 : dp[j] + dp[j+1];
            }
        }
        
        return dp[0];
    }


    public static void main(String[] args) {
        int grid[][]={{0,0,0,0},{0,1,0,1},{0,0,0,0},{1,0,1,0},{0,1,0,0}};
        System.out.println(uniquePathsWithObstacles(grid));
        System.out.println(uniquePathsWithObstacles_DP(grid));
        System.out.println(uniquePathsWithObstacles_DP1(grid));
    }
}

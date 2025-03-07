
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
    public static void main(String[] args) {
        int grid[][]={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(grid));
    }
}


import java.util.Arrays;

public class minimumCostPath {
    public static int minCost(int arr[][], int m, int n){
        return helper(arr,m,n,0,0);
    }

    private static int helper(int arr[][],int m, int n, int i, int j){
        if(i==m-1 && j==n-1) return arr[i][j];
        int op1=Integer.MAX_VALUE,op2=Integer.MAX_VALUE,op3=Integer.MAX_VALUE;
        if(i<m && j+1<n){
            op1=helper(arr,m,n,i,j+1);
        }
        if(i+1<m && j<n){
            op2=helper(arr,m,n,i+1,j);
        }
        if(i+1<m && j+1<n){
            op3=helper(arr,m,n,i+1,j+1);
        }
        return arr[i][j]+Math.min(op1,Math.min(op2,op3));
    }

    public static int minCostM(int arr[][], int m, int n){
        int memo[][]=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(memo[i],-1);
        return helperM(arr,m,n,0,0,memo);
    }

    private static int helperM(int arr[][],int m, int n, int i, int j,int memo[][]){
        if(i==m-1 && j==n-1)  return arr[i][j];

        if(i>=m || j>=n) return Integer.MAX_VALUE;

        if(memo[i][j]!=-1) return memo[i][j];

        int op1=helperM(arr,m,n,i,j+1,memo);
        int op2=helperM(arr,m,n,i+1,j,memo);
        int op3=helperM(arr,m,n,i+1,j+1,memo);

        memo[i][j]=arr[i][j]+Math.min(op1,Math.min(op2,op3));

        return memo[i][j];
    }

    //Not a good approach
    public static int minCost_DP(int arr[][], int m, int n){
        int i=m-1,j=n-1;
        int ans=0;
        while(i>0 || j>0){
            ans+=arr[i][j];
            if (i>0 && j> 0) {
                if (arr[i - 1][j] < arr[i][j - 1]) {
                    i--;  // Move up
                    if (arr[i][j-1] < arr[i][j]) j--;
                } else {
                    j--;  // Move left
                    if (arr[i-1][j] < arr[i][j]) i--;
                }
            }
        }
        ans+=arr[0][0];
        return ans;
    }
    
    public static int minCost_DP(int arr[][]){
        int m=arr.length;
        int n=arr[0].length;
        int memo[][]=new int[m][n];

        for(int i=0;i<m;i++) Arrays.fill(memo[i],-1);

        memo[m-1][n-1]=arr[m-1][n-1];
        //Last Column addition
        for(int i=m-2;i>=0;i--) memo[i][n-1]=arr[i][n-1]+memo[i+1][n-1];
        //Last Row addition
        for(int j=n-2;j>=0;j--) memo[m-1][j]=arr[m-1][j]+memo[m-1][j+1];

         for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                memo[i][j]=arr[i][j]+Math.min(memo[i+1][j+1],Math.min(memo[i+1][j],memo[i][j+1]));
            }
         }
         return memo[0][0];
        

    }
    public static void main(String[] args) {
        int arr[][]={{5,7,2,4},{1,8,1,3},{6,2,9,5},{1,6,2,9}};
        int m=4,n=4;
        System.out.println(minCost(arr,m,n));
        System.out.println(minCostM(arr,m,n));
        //System.out.println(minCost_DP(arr,m,n));
        System.out.println(minCost_DP(arr));
        int arr1[][]={{1,2,3,1},{6,5,4,2},{7,8,9,3},{4,9,1,10}};
        System.out.println(minCost(arr1,m,n));
        System.out.println(minCostM(arr1,m,n));
        //System.out.println(minCost_DP(arr,m,n));
        System.out.println(minCost_DP(arr1));
    }
}

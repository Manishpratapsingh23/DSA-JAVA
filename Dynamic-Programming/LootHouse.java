
import java.util.Arrays;

/*
 * A thief wants to loot houses. He knows the amount of money in each house. 
 * He cannot loot two consecutive houses. Find the maximum amount of money he can loot.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
6
5 5 10 100 10 5
Sample Output 1 :
110
Sample Input 2 :
6
10 2 30 20 3 50
Sample Output 2 :
90
Explanation of Sample Output 2 :
Looting first, third, and the last houses([10 + 30 + 50]) will result in the maximum loot, 
and all the other possible combinations would result in less than 90.
 */
public class LootHouse {
    public static int loot_DP(int arr[]){
        int l=arr.length;
        if(l==0) return 0;
        if(l==1) return arr[0];
        int dp[]=new int[l];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<l;i++){
            int max1=arr[i]+dp[i-2];
            dp[i]=Math.max(max1,dp[i-1]);
        }
        return dp[l-1];
    }
    public static int loot_M(int arr[]){
        if(arr.length==0) return 0;
        int[] memo=new int[arr.length];
        Arrays.fill(memo,-1);
        return helperM(arr,memo,arr.length-1);
    }
    private static int helperM(int arr[], int memo[], int n){
        if(n<0) return 0;
        if(memo[n]!=-1) return memo[n];
        int op1=arr[n]+helperM(arr, memo, n-2);
        int op2=helperM(arr, memo, n-1);
        memo[n]=Math.max(op1,op2);
        return memo[n];
    }
    public static void main(String[] args) {
        int arr[]={10,2,30,20,3,50};
        System.out.println(loot_DP(arr));
        System.out.println(loot_M(arr));
    }
}

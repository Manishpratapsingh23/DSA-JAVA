import java.util.Arrays;
import java.util.Scanner;

public class FrogJumpWithK {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);;
        // System.out.println(frogJumpDP(new int[]{15, 4, 1, 14, 15}, 3));
        // System.out.println(frogJumpDP(new int[]{10, 5, 20, 0, 15}, 2));
        // System.out.println(frogJumpM(new int[]{15, 4, 1, 14, 15}, 3));
        // System.out.println(frogJumpM(new int[]{10, 5, 20, 0, 15}, 2));
        System.out.println(frogJumpOptimalDP(new int[]{15, 4, 1, 14, 15}, 3));
        System.out.println(frogJumpOptimalDP(new int[]{10, 5, 20, 0, 15}, 2));
    }
    public static long frogJump(int[] heights, int k) {
        return helper(0,heights,k);
    }

    private static long helper(int idx, int heights[], int k){
        if(idx==heights.length-1) return 0;
        long minSteps = Integer.MAX_VALUE;
        for(int i=1;i<=k && i+idx<heights.length ;i++){
            long ans = helper(idx+i, heights, k) + Math.abs(heights[idx]-heights[idx+i]);
            minSteps = Math.min(minSteps, ans);
        }
        return minSteps;
    }

    public static long frogJumpM(int[] heights, int k) {
        int n = heights.length;
        long memo[] = new long[n];
        Arrays.fill(memo,-1);
        memo[n-1] = 0;
        return helperM(0,heights,k, memo);
    }

    private static  long helperM(int idx, int heights[], int k, long memo[]){
        if(idx==heights.length-1) return 0;
        if(memo[idx]!=-1) return memo[idx];
        long minSteps = Integer.MAX_VALUE;
        for(int i=1;i<=k && i+idx<heights.length ;i++){
            long ans = helperM(idx+i, heights, k, memo) + Math.abs(heights[idx]-heights[idx+i]);
            minSteps = Math.min(minSteps, ans);
        }
        return memo[idx] = minSteps;
    }


    // TC : O(N*K)  SC : O(N)
    public static long frogJumpDP(int[] heights, int k) {
        int n = heights.length;
        long dp[] = new long[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            long minSteps = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    long jump = dp[i-j]+Math.abs(heights[i]-heights[i-j]);
                    minSteps =  Math.min(minSteps, jump);
                }
            }
            dp[i]=minSteps;
        }
        return dp[n-1];
    }


    public static long frogJumpOptimalDP(int[] heights, int k) {
        int n = heights.length;
        long dp[] = new long[k+1];
        dp[0]=0;
        for(int i=1;i<n;i++){
            long minSteps = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int prev = (i-j)%(k+1);
                    long jump = dp[prev]+Math.abs(heights[i]-heights[i-j]);
                    minSteps =  Math.min(minSteps, jump);
                }
            }
            dp[i%(k+1)]=minSteps;
        }
        return dp[(n-1)%(k+1)];
    }
}
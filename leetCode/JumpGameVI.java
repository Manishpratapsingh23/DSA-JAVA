
import java.util.Arrays;

public class JumpGameVI{
    public static int maxResult(int[] nums, int k) {
        return helper(nums,k,0);
    }
    private static int helper(int nums[], int k, int index){
        if(index==nums.length-1) return nums[index];
        int ans=Integer.MIN_VALUE;
        for (int i = 1; i <= k && index + i < nums.length; i++) {
            ans=Math.max(ans,helper(nums,k,index+i));
        } 
        return nums[index]+ans;
    }

    public static int maxResultM(int[] nums, int k) {
        int memo[]=new int[nums.length];
        Arrays.fill(memo,-1);
        memo[nums.length-1]=nums[nums.length-1];
        return helperM(nums,k,0,memo);
    }
    private static int helperM(int nums[], int k, int index,int memo[]){
        if(index==nums.length-1) return memo[index];
        if(memo[index]!=-1) return memo[index];
        int ans=Integer.MIN_VALUE;
        for (int i = 1; i <= k && index + i < nums.length; i++) {
            ans=Math.max(ans,helperM(nums,k,index+i,memo));
        } 
        memo[index]=ans+nums[index];
        return memo[index];
    }

    public static int maxResult_DP1(int[] nums, int k) {
        int dp[]=new int[nums.length];
        dp[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            int max=Integer.MIN_VALUE;
            for(int j=1;j<=k && i+j<nums.length;j++) max=Math.max(max,dp[i+j]);
            dp[i]=max+nums[i];
        }
        return dp[0];
    }

    public static int maxResult_DP2(int[] nums, int k) {
        int dp[]=new int[nums.length];
        dp[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            dp[i]=Math.max(dp[i+1],dp[i+1]+nums[i]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int nums[]={1,-1,-2,4,-7,3};
        int k=2;
        int nums1[]={10,-5,-2,4,0,3};
        int k1=3;

        System.out.println(maxResult_DP1(nums, k));
        System.out.println(maxResult_DP2(nums, k));

        System.out.println(maxResult_DP1(nums1, k1));
        System.out.println(maxResult_DP2(nums1, k1));
        //System.out.println(maxResultM(nums, k));
        //System.out.println(maxResult(nums, k));
    }
}
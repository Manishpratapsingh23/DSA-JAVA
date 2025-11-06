import java.util.*;
public class LongestIncreasingSubsequnce {
    public static int lengthOfLIS(int[] nums) {
        return helper(nums,0,-1);
    }

    private static int helper(int[] nums, int idx, int prev_idx){
        if(idx==nums.length) return 0;
        int op1 = helper(nums,idx+1,prev_idx);
        int op2 = Integer.MIN_VALUE;
        if(prev_idx==-1 || nums[idx]>nums[prev_idx]){
            op2 = 1+helper(nums, idx+1, idx);
        }
        return Math.max(op1,op2);
    }
    public static int lengthOfLISM(int[] nums) {
        int n = nums.length;
        int memo[][] = new int[n][n+1];
        for(int arr[] : memo) Arrays.fill(arr, -1);
        return helperM(nums,0,-1, memo);
    }

    private static int helperM(int nums[], int idx, int prev_idx, int memo[][]){
        if(idx==nums.length) return 0;
        if(memo[idx][prev_idx+1]!=-1) return memo[idx][prev_idx+1];
        int op1 = helperM(nums,idx+1,prev_idx, memo);
        int op2 = Integer.MIN_VALUE;
        if(prev_idx==-1 || nums[idx]>nums[prev_idx]){
            op2 = 1+helperM(nums, idx+1, idx, memo);
        }
        return memo[idx][prev_idx+1] = Math.max(op1,op2);
    }

    public static void main(String args[]){
        int nums[] = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLISM(nums));
    }
}

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    public static void main(String[] args) {
        int arr[] = {2,2,3,3,3,4};
        System.out.println(solve(arr));
    }
    public static int solve(int[] nums) {
        return helper(nums,0, -1);
    }

    private static int helper(int nums[], int idx, int prev){
        if(idx==nums.length) return 0;
        int sum = nums[idx];
        int j = idx+1;
        while(j<nums.length && nums[idx]==nums[j]) sum+=nums[j++];
        int op1 = Integer.MIN_VALUE;
        if(prev==-1 || (prev+1)!=nums[idx]){
            op1 = sum+helper(nums,j,nums[idx]);
        }
        int op2 = helper(nums,j,prev);
        return Math.max(op1,op2);
    }

    public static int solveM(int[] nums) {
        Map<String, Integer> memo = new HashMap<>();
        return helperM(nums,0, -1, memo);
    }

    private static int helperM(int nums[], int idx, int prev, Map<String, Integer> memo){
        if(idx==nums.length) return 0;
        String key = idx+","+prev;
        if(memo.containsKey(key)) return memo.get(key);
        int sum = nums[idx];
        int j = idx+1;
        while(j<nums.length && nums[idx]==nums[j]) sum+=nums[j++];
        int op1 = Integer.MIN_VALUE;
        if(prev==-1 || (prev+1)!=nums[idx]){
            op1 = sum+helperM(nums,j,nums[idx], memo);
        }
        int op2 = helperM(nums,j,prev,memo);
        memo.put(key,Math.max(op1,op2));
        return Math.max(op1,op2);
    }
}
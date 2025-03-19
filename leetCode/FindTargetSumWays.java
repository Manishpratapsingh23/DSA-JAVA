import java.util.Arrays;
public class FindTargetSumWays {
    public static int findTargetSumWays(int[] nums, int target) {
        return helper(nums,target,0);
    }
    private static int helper(int nums[], int target, int index){
        if(index==nums.length && target==0) return 1;
        if(index==nums.length) return 0;
        int op1=helper(nums, target+nums[index], index+1);
        int op2=helper(nums, target-nums[index], index+1);
        return op1+op2;
    }

    public static int findTargetSumWaysM(int[] nums, int target) {
        int sum=0;
        for(int num : nums) sum+=num;
        // To handle negative indices, offset by sum
        int memo[][]=new int[nums.length][2*sum+1];
        for(int arr[]:memo) Arrays.fill(arr,-1);
        return helperM(nums,target,0,memo,sum);
    }
    private static int helperM(int nums[], int target, int index,int memo[][], int offset){
        if(index==nums.length) return target==0 ? 1:0;
        int shiftedTarget = target + offset; // Shift to handle negatives
        if (shiftedTarget < 0 || shiftedTarget >= 2 * offset + 1) return 0;
        if (memo[index][shiftedTarget] != -1) return memo[index][shiftedTarget];


        int op1=helperM(nums, target+nums[index], index+1,memo,offset);
        int op2=helperM(nums, target-nums[index], index+1,memo,offset);

        memo[index][shiftedTarget]=op1+op2;
        return memo[index][shiftedTarget];
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1,1,1};
        int nums1[] = {1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
        System.out.println(findTargetSumWays(nums, target));
        System.out.println(findTargetSumWays(nums1, target));
        System.out.println(findTargetSumWays(nums1, target));

    }
}

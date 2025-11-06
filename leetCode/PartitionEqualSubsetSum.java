
import java.util.Arrays;
class pair{
    boolean isVisited;
    boolean ans;
    public pair(boolean isVisited, boolean ans){
        this.isVisited = isVisited;
        this.ans = ans;
    }
}

public class PartitionEqualSubsetSum {
    static int sum = 0;
    static int target = 0;
    static int count = 0;
    public static boolean canPartition(int[] nums) {
        for(int i : nums) sum+=i;
        if(sum%2==1) return false;
        target = sum/2;
        return helper(nums,0,0,0);
    }

    private static boolean helper(int nums[], int idx, int s1, int s2){
        if(idx==nums.length){
            if(target==s1 || target==s2) count++;
            if(count==2) return true;
            return false;
        }
        boolean op1 = helper(nums, idx+1, s1+nums[idx], s2);
        boolean op2 = helper(nums, idx+1, s1, s2);
        return op1 || op2;
    }

    public static boolean canPartitionM(int[] nums) {
        int s=0;
        for(int i : nums) s+=i;
        if(s%2==1) return false;
        int target = s/2;
        pair memo[][] = new pair[nums.length][target];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<target;j++){
                memo[i][j] = new pair(false, false);
            }
        }
        return helperM(nums,0,0,memo, target).ans;
    }

    private static pair helperM(int nums[], int idx, int sum,  pair memo[][], int target){
        if(sum==target) return new pair(true, true);
        if(idx==nums.length || sum>target) return new pair(true, false);
        
        if(memo[idx][sum].isVisited) return memo[idx][sum];
        pair op1 = helperM(nums, idx+1, sum+nums[idx], memo, target);
        pair op2 = helperM(nums, idx+1, sum, memo, target);
        return memo[idx][sum] =  new pair(true, op1.ans || op2.ans);
    }

     public static boolean canPartitionM_efficient(int[] nums) {
        int s=0;
        for(int i : nums) s+=i;
        if(s%2==1) return false;
        int target = s/2;
        int memo[][] = new int[nums.length][target];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return helperM_efficient(nums,0,0,memo, target);
    }

    private static boolean helperM_efficient(int nums[], int idx, int sum,  int memo[][], int target){
        if(sum==target) return true;
        if(idx==nums.length || sum>target) return false;
        if(memo[idx][sum]==0) return false;
        boolean op1 = helperM_efficient(nums, idx+1, sum+nums[idx], memo, target);
        boolean op2 = helperM_efficient(nums, idx+1, sum, memo, target);
        memo[idx][sum]=0;
        return op1 || op2;
    }
    
    public static boolean canPartitionDP(int[] nums) {
        int sum = 0;
        for(int i : nums) sum+=i;
        if(sum%2==1) return false;
        target = sum/2;
        boolean isPossible[] = new boolean[target+1];
        isPossible[0]=true;
        for(int n : nums){
            for(int i=target;i>=0;i--){
                if(!isPossible[i]) continue;
                if(n+i<=target) isPossible[n+i] = true;
            }
        }
        return isPossible[target];
    }
    

    public static void main(String[] args) {
        int arr1[] = {1,5,11,5};
        System.out.println(canPartitionDP(arr1));

    }
}

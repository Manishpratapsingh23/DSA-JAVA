
import java.util.Arrays;



public class combinationSumIV {
    public static int combinationSum4(int[] nums, int target) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=helper(nums,i,target,0);
        }
        return ans;
    }

    private static int helper(int nums[],int index, int target,int sum){
        if(sum+nums[index]==target) return 1;
        if(sum+nums[index]>target) return 0;
        int ans=0;
        sum+=nums[index];
        for(int i=0;i<nums.length;i++){
            ans+=helper(nums,i,target,sum);
        }
        return ans;
    }

    public static int combinationSum4M(int[] nums, int target) {
        int memo[]=new int[target+1];
        Arrays.fill(memo,-1);
        memo[0]=1;
        return helperM(nums,target,memo);
    }
    private static int helperM(int nums[],int target, int memo[]){
        if(target==0) return 1;
        if(target<0) return 0;
        if(memo[target]!=-1) return memo[target];
        int ans=0;
        for(int i : nums){
            ans+=helperM(nums,target-i, memo);
        }
        memo[target]=ans;
        return memo[target];
    }

    
    public static void main(String[] args) {
        int arr[]={1,2,3};
        int target=3;
        System.out.println(combinationSum4(arr,target));
        System.out.println(combinationSum4M(arr,target));
    }
}

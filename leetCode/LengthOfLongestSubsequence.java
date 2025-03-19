
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthOfLongestSubsequence {
    public static int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int ans=helper(nums,target,0);
        return ans==Integer.MIN_VALUE ? -1 : ans;
    }
    private static int helper(List<Integer> nums, int target, int index){
        if(target==0) return 0;
        if(index==nums.size() || target<0) return Integer.MIN_VALUE;
        //Include the number
        int op1=helper(nums, target-nums.get(index), index+1);
        //Exclude the number
        int op2=helper(nums, target, index+1);
        if(op1!=Integer.MIN_VALUE) op1+=1;
        return Math.max(op1,op2);
    }

    public static int lengthOfLongestSubsequenceM(List<Integer> nums, int target) {
        int memo[][]=new int[nums.size()][target+1];
        for(int arr[]:memo) Arrays.fill(arr,-1);
        int ans=helperM(nums,target,0,memo);
        return ans==Integer.MIN_VALUE ? -1 : ans;
    }
    private static int helperM(List<Integer> nums, int target, int index, int memo[][]){
        if(target==0) return 0;
       
        if(index==nums.size() || target<0) return Integer.MIN_VALUE;
        if(memo[index][target]!=-1) return memo[index][target];

        //Include the number
        int op1=helperM(nums, target-nums.get(index), index+1,memo);

        //Exclude the number
        int op2=helperM(nums, target, index+1,memo);

        if(op1!=Integer.MIN_VALUE) op1+=1;
        memo[index][target]=Math.max(op1,op2);

        return memo[index][target];
    }
    public static void main(String[] args) {
        List<Integer> lst=new ArrayList<>();
        for(int i=1;i<=5;i++) lst.add(i);
        int target=9;
        System.out.println(lengthOfLongestSubsequence(lst, target));
        System.out.println(lengthOfLongestSubsequenceM(lst, target));
    }
}

import java.util.Arrays;

public class JumpGameII {
    public static int jump(int[] nums) {
        return jump(nums,0);
    }
    private static int jump(int nums[], int index){
        if(index==nums.length-1) return 1;
        if(index>=nums.length) return 0;
        int ans=0;
        for(int i=1;i<nums[index] && i+nums[index]<nums.length;i++){
            ans=Math.max(ans,jump(nums, index+nums[index]));
        }
        return 1+ans;
    }

    public static int jumpM(int[] nums) {
        int memo[]=new int[nums.length];
        Arrays.fill(memo,-1);
        return jumpM(nums,0,memo);
    }
    private static int jumpM(int nums[], int index,int memo[]){
        if(index==nums.length-1) return 1;
        if(index>=nums.length) return 0;
        if(memo[index]!=-1) return memo[index];
        int ans=0;
        for(int i=1;i<nums[index] && i+nums[index]<nums.length;i++){
            ans=Math.max(ans,jumpM(nums, index+nums[index],memo));
        }
        memo[index]=1+ans;
        return memo[index];
    }
    public static void main(String[] args) {
        int arr[]={2,1,1,1,4};
        System.out.println(jump(arr));
        System.out.println(jumpM(arr));
    }
}

public class JumpGame {
    public static boolean canJump(int[] nums) {
        return helper(nums,0);
    }
    private static boolean helper(int nums[], int index){
        if(index>=nums.length-1) return true;
        boolean ans=true;
        for(int i=1;i<=nums[index];i++){
            if(helper(nums,index+i)) return true;
        }
        return false;
    }

    public static boolean canJumpM(int[] nums) {
        return helper(nums,0);
    }
    private static boolean helperM(int nums[], int index){
        if(index>=nums.length-1) return true;
        boolean ans=true;
        for(int i=1;i<=nums[index];i++){
            if(helper(nums,index+i)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[]={2,3,1,1,4};
        System.out.println(canJump(arr));
    }
}

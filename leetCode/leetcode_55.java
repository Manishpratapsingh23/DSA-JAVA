public class leetcode_55 {
    public static void main(String[] args) {
        demo ob = new demo();
        int arr[] = { 2, 5, 0, 0 };
        System.out.println(ob.canJump(arr));
    }

}

class demo {

    public boolean canJump(int[] nums) {
        int l = nums.length;
        int jump = 0;
        if (l == 1 && nums[0] == 0)
            return true;
        for (int i = 0; i < l; i++) {
            if (jump >= l - 1)
                return true;
            if (nums[i] == 0)
                return false;

            jump += nums[i];
            i += nums[i];
            i = i - 1;

        }
        if (jump >= l)
            return true;
        return false;

    }
}

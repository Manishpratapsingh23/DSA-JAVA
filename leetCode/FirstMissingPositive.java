public class FirstMissingPositive {
    public static void main(String[] args) {
        int arr1[] = {3,4,-1,1};
        int arr2[] = {7,8,9,11,12};
        System.out.println(solve_optimal(arr1));
        System.out.println(solve_optimal(arr2));
    }

    public static  int solve(int[] nums) {
        int l = nums.length;
        boolean isMissing[] = new boolean[l+1];
        for(int i : nums){
            if(i>0 && i<=l) isMissing[i] = true;
        }
        for(int i=1;i<=l;i++) if(!isMissing[i]) return i;

        return l+1;
    }


    public static  int solve_optimal(int[] nums) {
        int l = nums.length;
        for(int i=0;i<l;i++){
            if(i<=0 & i>l) nums[i] = l+1;
        }

        for(int i=0;i<l;i++){
            int idx = Math.abs(nums[i]);
            if(idx>l) continue;
            idx--;
            if(nums[idx]>0) {
                nums[idx] *=-1;
            }
        }

        for(int i=0;i<l;i++) if(nums[i]>=0) return i+1;
        return l+1;
    }
}

public class leetcode2099 {
    //int k;
    //static int ans[];
    static int res[];
    static int maxSum;
    public static void main(String args[]){
        int arr[] = {2,1,3,3}; //k =2
        int arr2[] = {-1,-2,3,4}; //k= 3;
        print(maxSubsequence(arr, 2));
        print(maxSubsequence(arr2, 3));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        res = new int[k];
        maxSum = Integer.MIN_VALUE;
        helper(nums, k, 0, 0, new int[k]);
        return res;
    }

    private static void helper(int nums[], int k, int idx, int id, int ans[]){
        if(id==k){
            int sum = 0;
            for(int i : ans) sum += i;
            if(maxSum<sum){
                res = ans.clone();
                maxSum = sum;
            }
            return;
        }
       if (idx == nums.length) return;
        ans[id] = nums[idx];
        helper(nums, k, idx+1, id+1, ans);
        helper(nums, k, idx+1, id, ans);

    }

    private static void print(int arr[]){
        for(int i : arr) System.out.print(i+" ");
        System.out.println("    ");
    }
}

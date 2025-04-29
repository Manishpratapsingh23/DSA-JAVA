public class LongestIncreasingSubSequence {
    public static int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, 0, Integer.MIN_VALUE);
    }
    
    private static int lengthOfLIS(int nums[], int index, int prev){
        if(index==nums.length) return 0;
        int include=0;
        if(nums[index]>prev) include=1+lengthOfLIS(nums, index+1, nums[index]);
        int exclude=lengthOfLIS(nums, index+1, prev);
        return Math.max(include, exclude); 
        }
    public static void main(String[] args) {
        int arr[]={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));

        int arr1[]={0,1,0,3,2,3};
        System.out.println(lengthOfLIS(arr1));

        int arr2[]={7,7,7,7,7,7,7};
        System.out.println(lengthOfLIS(arr2));

        int arr3[]={10,9,2,5,3,7,21,13};
        System.out.println(lengthOfLIS(arr3));
    }
}

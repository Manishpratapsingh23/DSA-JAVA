/*
Given an array of integers nums and an integer k.
A continuous subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays.

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 */

public class countNiceSubArrays {
    public static void main(String args[]){
        int arr[] = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println();
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0) nums[i] = 0;
            else nums[i] = 1;
        }
        for(int i=1;i<nums.length;i++) nums[i] += nums[i-1];
        if(k>nums[nums.length-1]) return 0;
        



        return 0;
    }
}

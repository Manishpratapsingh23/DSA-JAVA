public class PartitionArrayForMaximumSum {
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        return helper(arr,k,0,1,0);
    }

    private static int helper(int nums[], int k, int idx, int count, int max){
        if(idx==nums.length) return 0;
        //count = (count+1)%k;
        int ans = 0;
        int count = 1;
        for(int i=idx;i+idx<nums.length;i++){

        }
    }
    public static void main(String[] args) {
        int arr[] = {1,15,7,9,2,5,10};
        System.out.println(maxSumAfterPartitioning(arr, 3));
    }
}

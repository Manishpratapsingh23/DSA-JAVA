public class MaximumPrimeDifference {
    public static int maximumPrimeDifference(int[] nums) {
        int left = 0, right = nums.length - 1;
        int x = -1, y = -1;

        while (left <= right) {
            if (x == -1 && checkPrime(nums[left])) {
                x = left;
            } else {
                left++;
            }
            if (y == -1 && checkPrime(nums[right])) {
                y = right;
            } else {
                right--;
            }
            if (x != -1 && y != -1) break;
        }

        // If there are no primes, return -1
        if (x == -1 || y == -1) return 0;

        return y - x;
    }

    private static boolean checkPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int num[] = {3, 49, 70, 9};
        //System.out.println(maximumPrimeDifference(num)); // Expected output: 0

        int num1[] = {10,10,9,3,2};
        System.out.println(maximumPrimeDifference(num1)); // Expected output: 3

        int num2[] = {10, 3, 30};
        //System.out.println(maximumPrimeDifference(num2)); // Expected output: -1 (no primes found)
    }
}

import java.util.*;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        List<String> results = new ArrayList<>();

        while (t-- > 0) {
            int n = sc.nextInt(); // Number of cows
            int m = sc.nextInt(); // Cards per cow
            int[][] decks = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    decks[i][j] = sc.nextInt();
                }
            }

            // Process current test case
            String result = solveTestCase(n, m, decks);
            results.add(result);
        }

        // Output all results
        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String solveTestCase(int n, int m, int[][] decks) {
        // Step 1: Sort each cow's deck
        for (int i = 0; i < n; i++) {
            Arrays.sort(decks[i]);
        }

        // Step 2: Try to find a valid permutation
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        // Step 3: Check if there's a valid turn order
        do {
            if (isValidOrder(order, decks, n, m)) {
                // Convert order to 1-based indexing
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(order[i] + 1).append(" ");
                }
                return sb.toString().trim();
            }
        } while (nextPermutation(order));

        return "-1";
    }

    private static boolean isValidOrder(Integer[] order, int[][] decks, int n, int m) {
        int topCard = -1;
        for (int round = 0; round < m; round++) {
            for (int i = 0; i < n; i++) {
                int cow = order[i];
                if (decks[cow][round] <= topCard) {
                    return false; // Cow can't play a card larger than the top card
                }
                topCard = decks[cow][round];
            }
        }
        return true;
    }

    private static boolean nextPermutation(Integer[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i < 0) return false;

        int j = nums.length - 1;
        while (nums[j] <= nums[i]) j--;

        // Swap i and j
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        // Reverse the suffix
        int left = i + 1, right = nums.length - 1;
        while (left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return true;
    }
}

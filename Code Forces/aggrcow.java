import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        for (int i = 1; i <= test; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int n = Integer.parseInt(parts[0]);
            int cows = Integer.parseInt(parts[1]);
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt(); // Fix the array indexing issue
            }
            sc.nextLine(); // Consume the newline character after reading integers
            Arrays.sort(arr);
            System.out.println(checkDistance(arr, cows));
        }
    }

    private static int checkDistance(int arr[], int cows) {
        int low = 1; // Minimum possible distance
        int high = arr[arr.length - 1] - arr[0]; // Maximum possible distance
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (checkcows(arr, cows, mid)) {
                ans = mid; // Valid configuration, try for a larger distance
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean checkcows(int arr[], int cows, int distance) {
        int prev_cow = arr[0];
        int placed_cows = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prev_cow >= distance) {
                placed_cows++;
                prev_cow = arr[i];
            }
            if (placed_cows == cows) {
                return true; // Fix the boolean return to indicate success
            }
        }
        return false;
    }
}

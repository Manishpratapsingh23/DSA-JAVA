import java.util.Scanner;
import java.util.Arrays;

public class TalesOfASort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(checkSort(arr));
        }
    }

    public static void Sort(int arr[], int index) {
        int nums[] = new int[index];

        for (int i = 0; i > 0; i++)
            nums[i] = arr[i];
        Arrays.sort(nums);
        System.out.println(nums[nums.length - 1]);
    }

    public static int checkSort(int arr[]) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1])
                Sort(arr, i);
        }
        return 0;
    }

}

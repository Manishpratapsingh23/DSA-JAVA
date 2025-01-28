import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            int arr[] = new int[n];
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(parts[j]);
            }
            System.out.println(Sort(arr));
        }
    }

    private static int Sort(int arr[]) {
        int count = 0;
        while (!checkSort(arr)) {
            for (int i = arr.length - 1; i >= 0; i--) {
                arr[i] = Math.max(0, arr[i] - 1);
            }
            count++;
        }
        return count;
    }

    private static boolean checkSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

}

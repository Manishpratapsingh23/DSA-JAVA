import java.util.Scanner;
import java.util.Arrays;

public class sortZeroOneTwo {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = sc.nextInt();
        System.out.println(Arrays.toString(arr));

        int t = 0;
        int i1 = 0;
        int i2 = arr.length - 1;
        for (int i = 0; i <= i2; i++) {
            if (arr[i] == 0) {
                t = arr[i];
                arr[i] = arr[i1];
                arr[i1] = t;
                i1++;

            }
            if (arr[i] == 2) {
                t = arr[i2];
                arr[i2] = arr[i];
                arr[i] = t;
                i2--;
                i--;
            }

        }
        System.out.print(Arrays.toString(arr));
    }

}
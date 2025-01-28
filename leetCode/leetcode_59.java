
/*Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

 */
import java.util.Scanner;

public class leetcode_59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.println("Enter dimension of matrix");
        int n = sc.nextInt();
        demo ob = new demo();
        ob.spiral_matrix(n);
        ob.display();

    }
}

class demo {
    int arr[][];

    public void spiral_matrix(int n) {
        arr = new int[n][n];
        int total = n * n;
        int t = 1;
        int ur = 0, uc = 0, lr = n - 1, lc = n - 1;
        while (t <= total) {
            for (int i = uc; i <= lc; i++) {
                arr[ur][i] = t;
                t++;
            }
            ur++;
            for (int i = ur; i <= lr; i++) {
                arr[i][lc] = t;
                t++;
            }
            lc--;
            for (int i = lc; i >= uc; i--) {
                arr[lr][i] = t;
                t++;
            }
            lr--;
            for (int i = lr; i >= ur; i--) {
                arr[i][uc] = t;
                t++;
            }
            uc++;

        }
    }

    public void display() {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.err.print(arr[i][j] + " ");
            }
            System.err.println();
        }
    }

}

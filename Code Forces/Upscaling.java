import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 0; t < test; t++) {
            int n = sc.nextInt();

            display(findmatrix(n));
        }
    }

    private static char[][] findmatrix(int n) {
        char arr[][] = new char[2 * n][2 * n];
        boolean flag = true;
        for (int i = 0; i < 2 * n; i += 2) {
            for (int j = 0; j < 2 * n; j += 2) {
                if (flag) {
                    arr[i][j] = '#';
                    arr[i][j + 1] = '#';
                    arr[i + 1][j] = '#';
                    arr[i + 1][j + 1] = '#';
                    flag = false;
                    if (j == 2 * n - 2 && n % 2 == 0)
                        flag = true;
                } else {
                    arr[i][j] = '.';
                    arr[i][j + 1] = '.';
                    arr[i + 1][j] = '.';
                    arr[i + 1][j + 1] = '.';
                    flag = true;
                    if (j == 2 * n - 2 && n % 2 == 0)
                        flag = false;
                }
            }
        }
        return arr;
    }

    public static void display(char arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j]);
            System.out.println();
        }

    }
}

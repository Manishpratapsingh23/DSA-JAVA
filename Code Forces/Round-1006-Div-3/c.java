import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            
            int[] key = new int[n];
            int xorSum = 0;

            for (int i = 0; i < n - 1; i++) {
                key[i] = i;
                xorSum ^= i;
            }

            key[n - 1] = xorSum ^ x;

            if (key[n - 1] >= n) {
                for (int i = 0; i < n - 1; i++) {
                    if ((xorSum ^ i ^ x) < n) {
                        key[n - 1] = xorSum ^ i ^ x;
                        key[i] = xorSum;
                        break;
                    }
                }
            }

            for (int num : key) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

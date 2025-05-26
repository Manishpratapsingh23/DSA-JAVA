import java.util.Scanner;

public class SmallestXORSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            if (n == 1) {
                System.out.println(x == 0 ? -1 : x);
            } else {
                long s = (n - 1) % 2;
                long y = x ^ s;
                if (y != 0) {
                    System.out.println((n - 1) + y);
                } else {
                    System.out.println(n + 3);
                }
            }
        }
        sc.close();
    }
}


import java.util.Scanner;

public class pipeLine {

    // Sum of first n natural numbers: 1 + 2 + ... + n
    static long sum(long n) {
        return (n * (n + 1)) / 2;
    }

    // Sum of range: s + (s+1) + ... + e
    static long sum(long s, long e) {
        if (s <= 1) {
            return sum(e);
        }
        return sum(e) - sum(s - 1);
    }

    // Binary search to find the minimum number of splitters needed
    static long minSplitters(long k, long n) {
        long left = 1, right = k;

        while (left < right) {
            long mid = (left + right) / 2;
            long s = sum(mid, k);

            if (s == n) {
                return k - mid + 1;
            }
            if (s > n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return k - left + 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        scanner.close();

        if (n == 1) {
            System.out.println(0); // Already have 1 pipe
        } else if (n <= k) {
            System.out.println(1); // We have a splitter that directly satisfies n
        } else {
            k--;
            n--;

            if (sum(k) < n) {
                System.out.println(-1); // Impossible to reach exactly n pipes
            } else {
                System.out.println(minSplitters(k, n));
            }
        }
    }
}

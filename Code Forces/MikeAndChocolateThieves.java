import java.util.Scanner;

public class MikeAndChocolateThieves {
    
    private static long possibleWays(long n) {
        long count = 0;

        // The largest starting value of `a` should be at most `n / 8`
        for (long a = 1; a * 8 <= n; a++) {
            for (long k = 2; ; k++) {
                long x = a;
                boolean valid = true;

                // Generate the sequence of length 4
                for (int i = 1; i < 4; i++) {
                    if (x > n / k) { 
                        valid = false;
                        break;
                    }
                    x *= k;
                }

                if (!valid) break; // If sequence is invalid, stop checking for this `a`
                count++;
                if (count > 10_000_000) return count; // Early exit if count is too large
            }
        }
        return count;
    }

    private static long solve(long m) {
        long left = 1, right = (long) 1e9, ans = -1;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long ways = possibleWays(mid);
            
            if (ways == m) {
                ans = mid;
                right = mid - 1; // Try to find a smaller n
            } else if (ways < m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        System.out.println(solve(m));
        sc.close();
    }
}

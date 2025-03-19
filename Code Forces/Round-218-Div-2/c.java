import java.util.Scanner;

public class c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String recipe = sc.next();
        long[] quantity = new long[3];
        long[] prices = new long[3];
        long money;
        
        for (int i = 0; i < 3; i++) quantity[i] = sc.nextLong();
        for (int i = 0; i < 3; i++) prices[i] = sc.nextLong();
        money = sc.nextLong();
        
        long[] freq = new long[3];
        for (char c : recipe.toCharArray()) {
            if (c == 'B') freq[0]++;
            else if (c == 'S') freq[1]++;
            else if (c == 'C') freq[2]++;
        }
        
        System.out.println(solve(freq, prices, quantity, money));
        
        sc.close();
    }

    public static long solve(long[] freq, long[] prices, long[] quantity, long money) {
        long left = 0, right = (long)1e13, ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (canMakeBurgers(mid, freq, prices, quantity, money)) {
                ans = mid; // Try making more burgers
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }

    public static boolean canMakeBurgers(long mid, long[] freq, long[] prices, long[] quantity, long money) {
        long cost = 0;
        
        for (int i = 0; i < 3; i++) {
            long needed = Math.max(0, mid * freq[i] - quantity[i]);
            cost += needed * prices[i];
            if (cost > money) return false; // Stop early if we exceed money
        }
        
        return cost <= money;
    }
}

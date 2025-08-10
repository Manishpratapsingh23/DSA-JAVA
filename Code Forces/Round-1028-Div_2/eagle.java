import java.util.*;

public class eagle {
    static int n, m;
    static double p;
    static HashMap<String, Double> memo;

    // Helper to compress state as a string for memoization
    static String stateKey(int[] h, int rounds) {
        Arrays.sort(h);
        StringBuilder sb = new StringBuilder();
        for (int x : h) {
            sb.append(x).append(",");
        }
        sb.append(rounds);
        return sb.toString();
    }

    static double dp(int[] h, int rounds) {
        // Base cases
        boolean allOne = true;
        for (int x : h) if (x != 1) allOne = false;
        if (allOne) return 1.0;
        if (rounds == 0) return 0.0;

        String key = stateKey(h, rounds);
        if (memo.containsKey(key)) return memo.get(key);

        // Sword shines: reduce all >1 by 1
        int[] hAll = h.clone();
        for (int i = 0; i < n; i++) if (hAll[i] > 1) hAll[i]--;
        double probShine = dp(hAll, rounds - 1);

        // Sword does not shine: choose best monster to reduce by 1
        double best = 0.0;
        for (int i = 0; i < n; i++) {
            if (h[i] > 1) {
                int[] hOne = h.clone();
                hOne[i]--;
                double candidate = dp(hOne, rounds - 1);
                if (candidate > best) best = candidate;
            }
        }

        double result = p * probShine + (1 - p) * best;
        memo.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test = 0; test < T; test++) {
            n = sc.nextInt();
            m = sc.nextInt();
            int pPrime = sc.nextInt();
            p = pPrime / 100.0;
            int[] h = new int[n];
            for (int i = 0; i < n; i++) h[i] = sc.nextInt();
            memo = new HashMap<>();
            double ans = dp(h, m);
            System.out.printf("%.6f\n", ans);
        }
    }
}

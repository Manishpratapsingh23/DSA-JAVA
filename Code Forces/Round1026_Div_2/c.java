import java.util.*;

public class c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] d = new int[n + 1];
            int[] l = new int[n + 1];
            int[] r = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                d[i] = sc.nextInt();
            }

            for (int i = 1; i <= n; i++) {
                l[i] = sc.nextInt();
                r[i] = sc.nextInt();
            }

            int[][] dp = new int[n + 1][2]; // dp[i][0]: min, dp[i][1]: max
            boolean ok = true;

            for (int i = 1; i <= n; i++) {
                int Xi_L, Xi_R;
                if (d[i] == 0) {
                    Xi_L = dp[i - 1][0];
                    Xi_R = dp[i - 1][1];
                } else if (d[i] == 1) {
                    Xi_L = dp[i - 1][0] + 1;
                    Xi_R = dp[i - 1][1] + 1;
                } else { // d[i] == -1
                    Xi_L = dp[i - 1][0];
                    Xi_R = dp[i - 1][1] + 1;
                }

                int Li = Math.max(l[i], Xi_L);
                int Ri = Math.min(r[i], Xi_R);

                if (Li > Ri) {
                    ok = false;
                    break;
                }

                dp[i][0] = Li;
                dp[i][1] = Ri;
            }

            if (!ok) {
                System.out.println(-1);
                continue;
            }

            int[] ans = new int[n + 1];
            int h = dp[n][0];

            for (int i = n; i >= 1; i--) {
                if (d[i] != -1) {
                    ans[i] = d[i];
                    h -= d[i];
                } else {
                    if (h >= dp[i - 1][0] && h <= dp[i - 1][1]) {
                        ans[i] = 0;
                    } else {
                        ans[i] = 1;
                        h -= 1;
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(ans[i]);
                if (i != n) System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();
    }
}

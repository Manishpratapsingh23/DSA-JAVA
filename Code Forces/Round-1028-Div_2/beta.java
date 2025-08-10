import java.util.*;

public class beta {
    static final int MOD = 998244353;
    static final int mamamamamam = 100000;
    static long[] pp = new long[mamamamamam];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        pcp();

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n];
            int[] q = new int[n];

            for (int i = 0; i < n; i++) p[i] = sc.nextInt();
            for (int i = 0; i < n; i++) q[i] = sc.nextInt();

            long[] r = new long[n];

            for (int i = 0; i < n; i++) {
                long rcb = 0;
                for (int j = 0; j <= i; j++) {
                    long mi = (pp[p[j]] + pp[q[i - j]]) % MOD;
                    rcb = Math.max(rcb, mi);
                }
                r[i] = rcb;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(r[i]);
                if (i < n - 1) System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();
    }

    static void pcp() {
        pp[0] = 1;
        for (int i = 1; i < mamamamamam; i++) {
            pp[i] = (pp[i - 1] * 2) % MOD;
        }
    }
}

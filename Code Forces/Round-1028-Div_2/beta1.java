import java.util.*;

public class beta1 {
    static final int mod = 998244353;
    static final int mm = 100000;
    static long[] pp = new long[mm];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        compute();
         int test = sc.nextInt();
        while (test-- > 0){
            int n=sc.nextInt();
            int[] p_arr = new int[n];
            int[] q_arr = new int[n];

            for (int i = 0; i < n; i++) p_arr[i] = sc.nextInt();
            for (int i = 0; i < n; i++) q_arr[i] = sc.nextInt();

            long ans[]=new long[n];
            for (int i = 0; i < n; i++) {
                long rcb = 0;
                for (int j = 0; j <= i; j++) {
                    long mi = (pp[p_arr[j]] + pp[q_arr[i - j]]) % mod;
                    rcb = Math.max(rcb, mi);
                }
                ans[i] = rcb;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i]);
                if (i < n - 1) System.out.print(" ");
            }
            System.out.println();
        }

    }

    private static void compute(){
        pp[0]=1;
        for(int i=1;i<mm;i++) pp[i]=(pp[i-1]*2)%mod;
    }
}

import java.util.*;

public class charlie {
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            int g = arr[0];
            for (int i = 1; i < n; i++) g = gcd(g, arr[i]);

            // Brute-force: simulate the process
            int minOps = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int ops = 0;
                int[] b = Arrays.copyOf(arr, n);
                // Try to make all elements equal to g, starting from position i
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        // Replace b[j] with gcd(b[j], b[i])
                        if (b[j] != g) {
                            b[j] = gcd(b[j], b[i]);
                            ops++;
                        }
                    }
                }
                // Now, check how many more operations are needed
                boolean changed = true;
                while (changed) {
                    changed = false;
                    for (int j = 0; j < n; j++) {
                        if (b[j] != g) {
                            b[j] = gcd(b[j], g);
                            ops++;
                            changed = true;
                        }
                    }
                }
                minOps = Math.min(minOps, ops);
            }
            System.out.println(minOps);
        }
        sc.close();
    }
}

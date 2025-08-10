import java.util.*;

public class c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            int count = 0;
            int last = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (a[i] > last + 1) {
                    count++;
                    last = a[i];
                }
            }
            System.out.println(count);
        }
    }
}

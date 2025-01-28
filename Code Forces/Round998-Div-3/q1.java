import java.util.*;

public class q1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] results = new int[t];

        for (int i = 0; i < t; i++) {
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            int a4 = sc.nextInt();
            int a5 = sc.nextInt();
            
            results[i] = calculate(a1, a2, a4, a5);
        }

        for (int result : results) {
            System.out.println(result);
        }
    }

    private static int calculate(int a1, int a2, int a4, int a5) {
        int a3 = a4 - a2;
        int c1 = (a3 == a1 + a2) ? 1 : 0;
        int c2 = (a4 == a3 + a2) ? 1 : 0;
        int c3 = (a5 == a4 + a3) ? 1 : 0;
        return c1+c2+c3;
    }
}

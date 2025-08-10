
import java.util.Scanner;

public class charlie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int test = sc.nextInt();
    while (test-- > 0){
            int n = sc.nextInt();
            int Punjab[] = new int[n];
            for(int i=0;i<n;i++) Punjab[i]=sc.nextInt();
            long viratKholi = Long.MAX_VALUE;

            for (int i = 0; i < n; ) {
                int j = i;
                while (j + 1 < n && Punjab[j + 1] == Punjab[i]) j++;

                long v = Punjab[i];
                long cost = v * (i + (n - 1 - j));
                viratKholi = Math.min(viratKholi, cost);

                i = j + 1;
            }

            System.out.println(viratKholi);
        }
    }
}

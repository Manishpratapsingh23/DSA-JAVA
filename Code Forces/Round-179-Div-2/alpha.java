
import java.util.Scanner;

public class alpha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int test = sc.nextInt();
        while (test-- > 0){
            int limit = sc.nextInt();
            int sara = 63 - Long.numberOfLeadingZeros(limit);
            long result = 2L * sara + 3;

            System.out.println(result);
        }
    }
}

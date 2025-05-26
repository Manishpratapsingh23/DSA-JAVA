import java.util.Scanner;

public class PermutationWarmUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t-- > 0) {
            int n = sc.nextInt();
            
            if (n <= 4) {
                int[] knownValues = {0, 1, 2, 3, 5};
                System.out.println(knownValues[n]);
            } else {
                int[] sequence = new int[n + 1];
                sequence[0] = 0;
                sequence[1] = 1;
                sequence[2] = 2;
                sequence[3] = 3;
                sequence[4] = 5;
                
                for (int i = 5; i <= n; i++) {
                    sequence[i] = sequence[i - 1] + i/2;
                }
                
                System.out.println(sequence[n]);
            }
        }
        
        sc.close();
    }
}

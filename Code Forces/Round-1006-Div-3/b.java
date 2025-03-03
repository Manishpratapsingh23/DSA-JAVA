import java.util.Scanner;

public class b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            
            // Count the number of '-' and '_'
            int dashCount = 0;
            int underscoreCount = 0;
            for (char c : s.toCharArray()) {
                if (c == '-') {
                    dashCount++;
                } else {
                    underscoreCount++;
                }
            }

            // Calculate the maximum number of "-_-" subsequences
            int maxSubsequences = Math.min(dashCount / 2, underscoreCount);
            System.out.println(maxSubsequences * (maxSubsequences + 1) * (maxSubsequences + 2) / 6);
        }
    }
}

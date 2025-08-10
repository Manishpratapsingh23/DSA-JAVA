import java.util.Scanner;

public class b {
    static void solve(Scanner sc) {
        int n = Integer.parseInt(sc.next());
        int k = Integer.parseInt(sc.next());
        String s = sc.next();

        int zeroCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                zeroCount++;
            }
        }
        int oneCount = n - zeroCount;

        int totalPairs = n / 2;
        int requiredBad = totalPairs - k;

        if (zeroCount < requiredBad || oneCount < requiredBad) {
            System.out.println("NO");
            return;
        }

        int remainingZeros = zeroCount - requiredBad;
        int remainingOnes = oneCount - requiredBad;

        int zeroPairs = remainingZeros / 2;
        int onePairs = remainingOnes / 2;

        int totalGoodPairs = zeroPairs + onePairs;

        if (totalGoodPairs >= k) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        for (int i = 0; i < t; i++) {
            solve(sc);
        }
        sc.close();
    }
}

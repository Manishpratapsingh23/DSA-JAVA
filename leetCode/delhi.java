import java.util.Scanner;

class delhi {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            int se = 0;
            int so = 0;
            while (n > 0) {
                int r = (int) n % 10;
                if (r % 2 == 0)
                    se += r;
                else
                    so += r;
                n = n / 10;
            }
            if (se % 4 == 0 || so % 3 == 0)
                System.out.println("yes");
            else
                System.out.println("no");
        }

    }
}

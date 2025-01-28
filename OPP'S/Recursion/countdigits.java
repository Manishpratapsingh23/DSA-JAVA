package Recursion;

public class countdigits {
    public static int countofdigits(int n) {
        if (n == 0)
            return 0;
        int ans = countofdigits(n / 10) + 1;
        return ans;
    }

    public static void main(String[] args) {
        {
            int n = 123456789;
            System.out.println(countofdigits(n));
        }
    }

}

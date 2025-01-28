package Recursion;

public class factorial {
    public static int fact(int n) {
        if (n == 0)
            return 1;
        int small = fact(n - 1);
        return n * small;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fact(n));
    }

}

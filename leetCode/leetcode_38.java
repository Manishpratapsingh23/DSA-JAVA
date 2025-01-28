import java.util.Scanner;

public class leetcode_38 {
    public static String CountNadSay(int n) {
        String st = 1;
        int count = 0;
        for (int i = 1; i < n; i++) {
            String str = "";
            for (int i = 0; i < st.length(); i++) {

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter number");
        int n = sc.nextInt();
        System.out.println(CountNadSay(n));
    }
}

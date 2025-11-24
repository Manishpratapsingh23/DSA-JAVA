import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {

        // When NOT running on an online judge
        if (System.getProperty("ONLINE_JUDGE") == null) {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n);
        System.out.println("Hello World!");
        sc.close();
    }
}

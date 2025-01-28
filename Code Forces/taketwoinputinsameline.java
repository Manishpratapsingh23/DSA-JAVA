import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
public class taketwoinputinsameline {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String input = sc.nextLine();
        String[] parts = input.split(" ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        System.out.println(a+" and "+b);


    }
}

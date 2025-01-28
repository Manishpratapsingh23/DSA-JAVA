import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        sc.nextLine();
        for(int i=1;i<=test;i++)
        {
            String input = sc.nextLine();
        String[] parts = input.split(" ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        int c = Integer.parseInt(parts[2]);
        if(a+b==c || b+c==a || c+a==b)
        System.out.println("YES");
        else
        System.out.println("NO");
        }

    }
}

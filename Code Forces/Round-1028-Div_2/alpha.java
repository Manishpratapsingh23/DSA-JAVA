
import java.util.Scanner;

public class alpha {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int d=sc.nextInt();
            int gt = Math.min(a,c);
            int ft = Math.min(b,d);
            if(gt>=ft) System.out.println("Gellyfish ");
            else System.out.println("Flower ");
        }
    }
}

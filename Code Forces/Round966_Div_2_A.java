import java.util.Scanner;
// Round966_Div_2_A
public class  Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            int distance=Math.abs(a-b);
            if (distance >= 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

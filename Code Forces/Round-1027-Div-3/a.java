import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            String s = sc.nextLine();
            int year = Integer.parseInt(s);
            if(year == 0){
                System.out.println(0 + " " + 0);
            }else{
                int root = (int)Math.sqrt(year);
                if(root * root == year) {
                    int a = root - 1;
                    int b = 1;
                    System.out.println(a + " " + b);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}

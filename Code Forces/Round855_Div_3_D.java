
import java.util.Scanner;
// Round855_Div_3_D
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=1;j<=t;j++){
            int l=sc.nextInt();
            sc.nextLine();
            String st=sc.nextLine();
            if (l < 2) { 
                System.out.println(0);
                continue;
            }
            int count=1;
            for (int i = 0; i + 2 < l; i++) {
                if(st.charAt(i)!=st.charAt(i+2)) count++;
            }

            System.out.println(count);
        }
    }
}

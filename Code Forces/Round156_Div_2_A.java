
import java.util.Scanner;
// Round156_Div_2_A
public class  Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int j=1;j<=t;j++){
            int n=sc.nextInt();
            boolean check=false;
            for(int i=1;i<n;i++){
                if(i%3==0) continue;
                int left=i+1;
                int right=n-1;
                while(left< right){
                    if(left%3!=0 && right%3!=0){
                        if(i+left+right==n){
                            System.out.println("YES");
                            System.out.println(i+" "+left+" "+right);
                            check=true;
                            break;
                        }
                        else if(left+right+i>n) right--;
                        else left++;
                    }
                    if(right%3==0) right--;
                    if(left%3==0) left++;
                }
                if(check) break;
            }
            if(!check) System.out.println("NO");
        }
    }
}

import java.util.Scanner;
public class sequence{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        print(n,0,"");
    }
    private static  void print(int n,int curr,String ans)
    {
        if(curr==n)
        {
            System.out.println(ans);
            return;
        }
        if(curr>n)
        {
            return;
        }
        print(n,curr+1,ans+1);
        print(n,curr+2,ans+2);
        print(n,curr+3,ans+3);

    }
}

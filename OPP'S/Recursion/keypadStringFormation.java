import java.util.Scanner;
public class keypadStringFormation {
    public static String[] keypad(int n)
    {
        
        if(n==0)
        {
            String output[]={""};
            return output;
        }
        int num=n%10;
        String[] small_ans=keypad(n/10);
        String input;/*="";*/
        input = switch (num) {
            case 2 -> "abc";
            case 3 -> "def";
            case 4 -> "ghi";
            case 5 -> "jkl";
            case 6 -> "mno";
            case 7 -> "pqrs";
            case 8 -> "tuv";
            default -> "wxyz";
        };
            int ans_size=input.length()*small_ans.length;
            String ans[]=new String[ans_size];
            int k=0;
            for(int i=0;i<small_ans.length;i++)
            {
                for(int j=0;j<input.length();j++)
                    ans[k++]=small_ans[i]+input.charAt(j);

            }
            return ans;
        }
        public static void main(String agrs[])
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Number");
            int n=sc.nextInt();
            String arr[]=keypad(n);
        for (String arr1 : arr) {
            System.out.println(arr1);
        }
        }
}

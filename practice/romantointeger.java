import java.util.Scanner;
class Sol {
    public static void main(String args[]) 
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter ROMAN number");
	String s = sc.nextLine();
        int l = s.length();
        char ch,ch1;
        int num = 0;
        for(int i=l-1;i>=0;i--)
        {
            ch = s.charAt(i);
            
            if(ch=='M')
            {
                if(s.charAt(i-1)=='C' && i>0){
                    num += 9000;
                i -= 1;
                }
                else
                num += 1000;
            }
            else if(ch=='D')
            {
                if(s.charAt(i-1)=='C' && i>0){
                num += 400;
                i -= 1;
                }
                else
                num += 500;
            }
            else if(ch=='C')
            {
                if(s.charAt(i-1)=='X' && i>0){
                num += 90;
                i -= 1;
                }
                else
                num += 100;
            }
            else if(ch=='L'){
                if(s.charAt(i-1)=='X' && i>0){
                num += 40;
                i -= 1;
            }
                else
                num += 50;
            }
            else if(ch=='X')
            {
                if(s.charAt(i-1)=='I' && i>0){
                num += 9;
                i -= 1;
                }
                else
                num += 10;
            }
            else if(ch=='V')
            {
                if(s.charAt(i-1)=='I' && i>0){
                num += 4;
                i -= 1;
                }
                else
                num += 5;
            }
            else if(ch=='I')
            num += 1;

        }
        System.out.println("The number is "+num);
    }
}
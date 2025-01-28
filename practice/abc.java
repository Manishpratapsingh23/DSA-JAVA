import java.util.Scanner;
class Solution {
    public long reverse(long x) {
	
        long r = 0;
        long s = 0;
        
        while(x!=0)
        {
            r = x%10;
            s = s*10 + r;
            x = x/10;
        }
        if(s>=-2147483648 && s<=2147483647)
        return s;
        else 
        
        {
        return 0;
        }
    }
}
class abc
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
	System.out.println("Enter number");
	long x = sc.nextInt();
	Solution ob = new Solution();
	System.out.println(ob.reverse(x));
	}
	}
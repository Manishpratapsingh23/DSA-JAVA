/*
Problem statement
Write a program to print N number of rows for Half Diamond pattern using stars and numbers

Note : There are no spaces between the characters in a single line.


Detailed explanation ( Input/output format, Notes, Images )
Input Format :
A single integer: N
Output Format :
Required Pattern
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
*
*1*
*121*
*12321*
*121*
*1*
*
Sample Input 2 :
 5
Sample Output 2 :
*
*1*
*121*
*12321*
*1234321*
*123454321*
*1234321*
*12321*
*121*
*1*
*



*/
import java.util.Scanner;

public class half_diamond_pattern{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
        int n = sc.nextInt();
        int t=1;
       if(n!=0)
       {
            for(int i=0;i<=n;i++){
            t=1;
            for(int j=1;j<=2*i+1;j++)
            {
                if(j==1||j==2*i+1)
                System.out.print("*");
                else{
                    if(j<=(2*i+1)/2)
                    {
                         System.out.print(t);
                         t += 1;
                    }
                    else
                    {
                        System.out.print(t);
                         t -= 1;
                    }
                }
            }
            System.out.println();
        }
         for(int i=n-1;i>=0;i--){
            t=1;
            for(int j=1;j<=2*i+1;j++)
            {
                if(j==1||j==2*i+1)
                System.out.print("*");
                else{
                    if(j<=(2*i+1)/2)
                    {
                         System.out.print(t);
                         t += 1;
                    }
                    else
                    {
                        System.out.print(t);
                         t -= 1;
                    }
                }
            }
            
            System.out.println();
        
        }
       }
       else{
           System.out.println("*");
           System.out.println("*");

       }
        
        
    }
}
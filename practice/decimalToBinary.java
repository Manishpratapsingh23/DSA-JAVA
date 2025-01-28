/*
Given a decimal number (integer N), convert it into binary and print.

Note for C++ coders:
Do not use the inbuilt implementation of "pow" function. The implementation of that function is done for 'double's and it may fail when used for 'int's, 'long's, or 'long long's. Implement your own "pow" function to work for non-float data types. 
The given input number could be large, so the corresponding binary number can exceed the integer range. So you may want to take the answer as long for CPP and Java. 


Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 10^5
Sample Input 1 :
12
Sample Output 1 :
1100
Sample Input 2 :
7
Sample Output 2 :
111
Sample Input 2 :
0
Sample Output 2 :
0

*/
import java.lang.Math;
import java.util.Scanner;
public class decimalToBinary{
	
	public static void main(String[] args) {
		// Write your code here
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int r=0;
		int sum=0;
		String st="";
		if(n==0)
		System.out.print(0);
		else
		{
		
		while(n!=0)
		{
			r=n%2;
			
			st = Integer.toString(r)+st;
			
			n = n/2;
		}
		if(n==1)
		st = st+'1';
		System.out.print(st);
		}

	}
}

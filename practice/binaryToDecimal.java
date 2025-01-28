/*
Given a binary number as an integer N, convert it into decimal and print.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 10^9
Sample Input 1 :
1100
Sample Output 1 :
12
Sample Input 2 :
111
Sample Output 2 :
7

*/


import java.lang.Math;
import java.util.Scanner;
public class binaryToDecimal {
	
	public static void main(String[] args) {
		// Write your code here
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int r=0;
		int sum=0;
		int i=0;
		while(n!=0)
		{
			r=n%10;
			sum = sum+r*(int)(Math.pow(2, i));
			i++;
			n = n/10;
		}
		System.out.print(sum);

	}
}

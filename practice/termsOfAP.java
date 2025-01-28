/*
Write a program to print first x terms of the series 3N + 2 which are not multiples of 4.


Constraints :
1 <= x <= 1,000
Sample Input 1 :
10
Sample Output 1 :
5 11 14 17 23 26 29 35 38 41
Sample Input 2 :
4
Sample Output 2 :
5 11 14 17
Explanation :
Input is 4 and print the first 4 numbers that are not divisible by 4 and are of the form 3N + 2, where k is a non-negative integer.   

*/

import java.util.Scanner;
public class termsOfAP {
	
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
		System.out.println("enter numbers");
		int n = sc.nextInt();
		int i=1;
		int t=1;
		while(i<=n)
		{
			if((3*t+2)%4!=0)
			{
				System.out.print((3*t+2)+" ");
				i++;
				t++;
			}
			else
			t++;

		}

	}
}

/*
Write a program to print parallelogram pattern for the given N number of rows.

For N = 4



The dots represent spaces.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
***
 ***
  ***
Sample Input 2 :
5
Sample Output 2 :
*****
 *****
  *****
   *****
    *****
	
	
*/
import java.util.Scanner;
public class parallelogram_pattern {
	
	public static void main(String[] args) {
		// Write your code here
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<i;j++)
			System.out.print(" ");
			for(int j=1;j<=n;j++)
			System.out.print("*");
			System.out.println();
		}

	}
}
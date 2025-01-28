/*
Write a program to print the pattern for the given N number of rows.

For N = 4

1357
3571
5713
7135
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
135
351
513
Sample Input 2 :
 5
Sample Output 2 :
13579
35791
57913
79135
91357
*/
import java.util.Scanner;

public class oddSquare {
    
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
			 System.out.println("Enter number");
            int n = sc.nextInt();
            int t =1;
            for(int i=1;i<=2*n;i+=2)
            {
                t=1;
                for(int j=i;j<=2*n; j+=2,t +=1)
                if(j<=2*n-1)
                System.out.print(j);
                int j =1;
                while(t<=n){
                    System.out.print(j);
                    j += 2;
                    t += 1;
                }
                System.out.println();
            }
        }
    

     
    
    
}
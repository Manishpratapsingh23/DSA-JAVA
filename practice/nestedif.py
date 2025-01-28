import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. 
        ,d1,y1 = sc.nextInt(),sc.nextInt();sc.nextInt();
       int m1,d1,y1 = sc.nextInt(),sc.nextInt(),sc.nextInt();*/
        Scanner sc = new Scanner(System.in);
       int m1 = sc.nextInt();
       int d1 = sc.nextInt();
       int y1 = sc.nextInt();
       int m2 = sc.nextInt();
       int d2 = sc.nextInt();
       int y2 = sc.nextInt();
       int fine = 0;
        if (y1<=y2)
        {
            if(d1>d2)
            {
                fine = 500*(d1-d2);
            }
            else
            {
                if(m1>m2)
                {
                    fine = 15*(m1-m2);
                }
                else
                {
                    fine = 0;
                }
            }
        }
        else
        {
            fine = 10000;
        }
        System.out.print(fine);
        
    }
}

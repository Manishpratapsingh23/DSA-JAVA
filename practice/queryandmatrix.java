/*you are given a binary matrix with ‘M’ rows and ‘N’ columns initially consisting of all 0s. 'Q' queries follow. The queries can be of 4 types:

Query 1: 1 R index
Query 2: 1 C index 
Query 3: 2 R index
Query 4: 2 C index

In each query, the first input is the type of the query, the second input is whether we have to consider the row ('R') or the column ('C') and the third input is the index of the row/column. 

For each type 1 query, we need to flip the elements of the row/column having the given index. 

For each type 2 query, we have to output the number of zeros present in the row/column having the given index. 
Note:
Note that the matrix is a binary matrix, meaning that it only contains either 0 or 1.
Example :
Given M = 3, N = 3, 
Queries : 1R1, 1R2, 2C1

So, in the above example the change in the matrix would look like this:
Example

Next query 2C1 will return the count of the number of zeroes in the 1st column: 1
*/


//main code
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int[][] matrix = new int[M][N];
            int Q = scanner.nextInt();
            scanner.nextLine();

            String[] queries = new String[Q];
            for (int i = 0; i < Q; i++) {
                queries[i] = scanner.nextLine();
            }

            int[] result = Solution.query(matrix, M, N, queries);

            for (int count : result) {
                System.out.print(count+" ");
            }
            System.out.println();
        }
    }
}

//Solution code;
public class queryandmatrix {
    public static int[] query(int[][] mat, int m, int n, String[] q) {
        // Write your code here.
        int len = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i].charAt(0) == '2')
                len++;
        }
        int a[] = new int[len];
        int ai = 0;
        for (int i = 0; i < q.length; i++) {

            char type = q[i].charAt(0);
            char ch = q[i].charAt(1);
            int index = Character.getNumericValue(q[i].charAt(2));
            if (type == '1') {
                if (ch == 'R') {
                    for (int j = 0; j < n; j++)
                        mat[index][j] = 1 - mat[index][j];
                } else {
                    for (int j = 0; j < n; j++)
                        mat[j][index] = 1 - mat[j][index];
                }
            } else {
                int count = 0;
                if (ch == 'R') {
                    for (int j = 0; j < n; j++) {
                        if (mat[index][j] == 0)
                            count++;
                    }
                } else {
                    for (int j = 0; j < n; j++)
                        if (mat[j][index] == 0)
                            count++;
                }
                a[ai++] = count;
            }
        }
        return a;
    }
}
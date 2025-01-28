import java.util.Scanner;

public class leetcode_463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][] = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        demo ob = new demo();
        int ans = ob.island_perimeter(arr);
        System.out.println("the perimeter is " + ans);

    }
}

class demo {
    public int island_perimeter(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;
        int p = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    p += 4;
                    if (j > 0 && grid[i][j - 1] == 1)
                        p -= 1;
                    if (j < n - 1 && grid[i][j + 1] == 1)
                        p -= 1;
                    if (i > 0 && grid[i - 1][j] == 1)
                        p -= 1;
                    if (i < m - 1 && grid[i + 1][j] == 1)
                        p -= 1;

                }
            }
        }
        return p;
    }
}
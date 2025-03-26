
import java.util.Arrays;

    public class distance01Matrix {
        public static int[][] updateMatrix(int[][] mat) {
            int m=mat.length;
            int n=mat[0].length;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j]==1){
                        mat[i][j]=helper(mat, m, n, i, j, new boolean[m][n]);
                    }else{
                        mat[i][j]=0;    
                    }
                }
            }
            return mat;
        }
        private static int helper(int arr[][], int m, int n, int i, int j, boolean visited[][]){
            if(i<0 || i>=m || j<0 || j>=n) return Integer.MAX_VALUE/2;

            if(arr[i][j]==0) return 0;
            if(visited[i][j]) return Integer.MAX_VALUE/2;
            visited[i][j]=true;
            int up=1+helper(arr, m, n, i-1, j, visited);
            int down=1+helper(arr, m, n, i+1, j,visited);
            int left=1+helper(arr, m, n, i, j-1, visited);
            int right=1+helper(arr, m, n, i, j+1, visited);
            visited[i][j]=false;
            return Math.min(Math.min(up,down),Math.min(left,right));

        }

        public static int[][] updateMatrixM(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            int[][] memo = new int[m][n];
    
            // Initialize memo array with -1 (indicating uncomputed values)
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
    
            // Compute distance for each cell recursively
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        memo[i][j] = helperM(mat, i, j, m, n, memo);
                    } else {
                        memo[i][j] = 0; // Distance for 0 is always 0
                    }
                }
            }
            return memo;
        }
    
        private static int helperM(int[][] mat, int i, int j, int m, int n, int[][] memo) {
            // If out of bounds, return a large number (to avoid incorrect min calculations)
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return Integer.MAX_VALUE / 2;
            }
    
            // If already computed, return stored result
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
    
            // If the current cell is 0, return 0
            if (mat[i][j] == 0) {
                return 0;
            }
    
            // Initialize distance as a large number
            //int minDist = Integer.MAX_VALUE / 2;
    
            // Recursive calls in all four directions
                int op1=1+helperM(mat, i - 1, j, m, n, memo);
                int op2=1+helperM(mat, i + 1, j, m, n, memo);
                int op3=1+helperM(mat, i, j - 1, m, n, memo);
                int op4=1+helperM(mat, i, j + 1, m, n, memo);
    
            memo[i][j] = Math.min(Math.min(op1,op2),Math.min(op3,op4));
            return memo[i][j];
        }
    
        public static void main(String[] args) {
            System.out.println();
            int arr[][]={{0,0,0},{0,1,0},{0,0,0}};
            int arr1[][]={{0,0,0},{0,1,0},{1,1,1}};
            int ans[][]=updateMatrix(arr);
            for(int nums[]: ans){
                for(int i: nums) System.out.print(i+" ");
                System.out.println();
            }
            System.out.println();
            int ans1[][]=updateMatrix(arr1);
            for(int nums[]: ans1){
                for(int i: nums) System.out.print(i+" ");
                System.out.println();
            }
            System.out.println();
            int ansM[][]=updateMatrixM(arr);
            for(int nums[]: ansM){
                for(int i: nums) System.out.print(i+" ");
                System.out.println();
            }
            System.out.println();
            int ansM1[][]=updateMatrixM(arr1);
            for(int nums[]: ansM1){
                for(int i: nums) System.out.print(i+" ");
                System.out.println();
            }
            System.out.println();
        }
    }

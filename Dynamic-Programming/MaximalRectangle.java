
import java.util.Stack;


public class MaximalRectangle {

    public static void main(String[] args) {
        char grid[][]= {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(grid));
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int prefix[][] = new int[m][n];
        for(int j=0;j<n;j++){
            prefix[0][j] = matrix[0][j]== '1' ? 1 : 0;
            for(int i=1;i<m;i++){
                if(matrix[i][j]=='1'){
                    prefix[i][j] = 1+prefix[i-1][j];
                } else prefix[i][j] = 0;
            }
        }
        int maxrec = 0;
        for(int height[] : prefix){
            maxrec = Math.max(maxrec, largestArea(height));
        }
        return maxrec;
    }

    private static int largestArea(int heights[]){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                int h = heights[stack.pop()];
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, h*(nse-pse-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
                int h = heights[stack.pop()];
                int nse = heights.length;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, h*(nse-pse-1));
            }

        return maxArea;
    }

    private  static void print(int grid[][]){
        for(int arr[] : grid){
            for(int i : arr) System.out.print(i+" ");
            System.out.println();
        }
    }
}
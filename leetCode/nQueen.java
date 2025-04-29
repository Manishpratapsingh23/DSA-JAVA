
import java.util.ArrayList;
import java.util.List;

public class nQueen {
    public static List<List<String>> ans = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        ans.clear();
        int board[][] = new int[n][n];
        queen(board,0,n);
        return ans;
    }

    private static boolean queen(int[][] board, int row, int n) {
        if(row==n){
            List<String> res = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder st = new StringBuilder();
                for(int j=0;j<n;j++){
                    st.append(board[i][j] == 1 ? "Q" : ".");
                }
                res.add(st.toString());
            }
            ans.add(res);
            return true;
        }
        boolean r=false;
        for(int col=0;col<n;col++){
            if(isSafe(board, row, col)){
                board[row][col]=1;
                r = queen(board, row+1,n) || r;
                board[row][col]=0;
            }
        }
        return r;
    }
    private static boolean isSafe(int[][] board, int row, int col) {
        int i=row,j=col;
        while(i>=0){
            if(board[i][j] == 1) return false;
            i--;
        }
        i=row;
        j=col;
        while(i>=0 && j>=0){
            if(board[i][j] == 1) return false;
            i--;
            j--;
        }
        i=row;
        j=col;
        while(i>=0 && j<board.length){
            if(board[i][j] == 1) return false;
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        int n=4;
        List<List<String>>  ans =solveNQueens(n);
        // Output: 1 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0  
        System.out.println(ans);

    }
}

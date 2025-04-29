public class NQueens {
    public static void placeNQueens(int n){
        int [][]board = new int [n][n];
        queen(board,0);
        }
       private static boolean  queen(int board[][], int row){
        if(row==board.length){
            print(board);
            return true;
        }
        boolean res=false;
        for(int col=0;col<board.length;col++){
            if(isSafe(board, row, col)){
                board[row][col]=1;
                res = queen(board, row+1) || res;
                board[row][col]=0;
            }
        }
        return res;
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

    private static void print(int board[][]){
        System.out.println("//#endregion");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

        public static void main(String[] args) {
            int n=4;
            placeNQueens(n);
            // Output: 1 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0  

        }

    
}

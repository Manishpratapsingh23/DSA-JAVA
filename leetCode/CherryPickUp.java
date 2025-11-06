public class CherryPickUp {
    public static void main(String args[]){
        int grid[][] = {{0,1,-1},{1,0,-1},{1,1,1}};
        int ans = checkPick(grid);
        System.out.println(ans);
    }

    private static int checkPick(int grid[][]){
        int n = grid.length;
        int ans[][] = new int[n][n];
        ans[0][0] = grid[0][0];
        for(int i=1;i<n;i++){
            if(grid[0][i]!=-1 && ans[0][i-1]!=-1) ans[0][i] = ans[0][i-1]+grid[0][i];
            else ans[0][i] = -1;
        }

        for(int j=1;j<n;j++){
            if(grid[j][0]!=-1 && ans[j-1][0]!=-1) ans[j][0] = ans[j-1][0]+grid[j][0];
            else ans[j][0] = -1;
        }
        //display(ans);
        ans[0][0] = 0;

        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j]!=-1){
                    if(ans[i-1][j]>=ans[i][j-1]){
                        ans[i][j] = grid[i][j] + ans[i-1][j];
                        grid[i-1][j] = 0;
                    } else {
                        ans[i][j] = grid[i][j] + ans[i][j-1];
                        grid[i][j-1] = 0;
                }
                } else ans[i][j] = -1;
            }
            display(grid);
            display(ans);
            return ans[n-1][n-1];
        }





        return 0;
    }

    private static void display(int grid[][]){
        for(int arr[] : grid){
            for(int i : arr) System.out.print(i+" ");
            System.out.println("");
        }
    }
}

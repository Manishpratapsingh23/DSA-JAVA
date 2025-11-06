public class MinimumPathCostInAGrid {
    public static void main(String[] args) {
        int grid[][] ={{5,3},{4,0},{2,1}};
        int moveCost[][] = {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};

        // int grid[][] ={{5,3},{4,0},{2,1}};
        // int moveCost[][] = {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};


        System.out.println(minPathCost(grid,moveCost));
    }

    public static  int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int ans[][] = new int[m][n];
        for(int i=0;i<n;i++){
            ans[m-1][i] = grid[m-1][i];
        }

        for(int i=m-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int min = Integer.MAX_VALUE;
                for(int k=0;k<n;k++){
                    min = Math.min(min, ans[i+1][k]+moveCost[grid[i][j]][k]);
                } 
                ans[i][j] = grid[i][j]+min;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i : ans[0]){
            res = Math.min(res,i);
        }
        return res;
    }
}

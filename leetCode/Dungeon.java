public class Dungeon{
    static int ans2 = Integer.MAX_VALUE;
    public static void main(String args[]){
        int grid[][] = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int ans1 =  calculateMinimumHP(grid);
        System.out.println(ans1);
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // helper(dungeon,m-1,n-1,0);
        // return ans+1;
        int ans[][] = new int[m][n];
        ans[m-1][n-1] = Math.max(1,1-dungeon[m-1][n-1]);
        for(int i=m-2;i>=0;i--) ans[i][n-1] = Math.max(1, ans[i+1][n-1]-dungeon[i][n-1]);
        for(int j=n-2;j>=0;j--) ans[m-1][j] = Math.max(1, ans[m-1][j+1]-dungeon[m-1][j]);

        for(int j=n-2;j>=0;j--){
            for(int i=m-2;i>=0;i--){
               int health = Math.min(ans[i + 1][j], ans[i][j + 1]);
                ans[i][j] = Math.max(1, health - dungeon[i][j]);
            }
        }
        //display(ans);
        return ans[0][0];
    }

    private static void display(int grid[][]){
        for(int arr[] : grid){
            for(int i : arr) System.out.print(i+" ");
            System.out.println("");
        }
    }

    private static  void helper(int grid[][], int x, int y, int sum){
        if(x<0 || y<0) return;
        if(x==0 && y==0){
            sum+=grid[x][y];
            sum = sum<0 ? sum*-1 : sum;
            ans2 = Math.min(ans2,sum);
            return;
        }
        helper(grid, x-1, y, sum+grid[x][y]);
        helper(grid, x, y-1, sum+grid[x][y]);
    }
}
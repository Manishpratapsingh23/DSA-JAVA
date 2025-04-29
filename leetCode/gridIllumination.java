public class gridIllumination {
    private static int x_dir[]={-1,-1,-1,0,1,1,1,0};
    private static int y_dir[]={-1,0,1,1,1,0,-1,-1};
    public static int[] grid_Illumination(int n, int[][] lamps, int[][] queries) {
        int grid[][] = new int[n][n];
        for(int arr[] : lamps){
            lampTurnON(grid, arr[0],arr[1]);
        }
        int ans[] = new int[queries.length];
        int k=0;
        for(int arr[] : queries){
            int x = arr[0];
            int y = arr[1];
            if(grid[x][y]==1 || grid[x][y]==2) ans[k++]=1;
           // else if(grid[x][y]==1) grid[x][y]=0;
            lampTurnOFF(grid, x, y);
        }
        return ans;
    }

    private static void lampTurnON(int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid.length) return;
        grid[i][j]=1;
        for(int t=0;t<8;t++){
            int x = x_dir[t];
            int y = y_dir[t];
            int X = i+x;
            int Y = j+y;
            while(X>=0 && X<grid.length && Y>=0 && Y<grid.length){
                if(grid[X][Y]==0) grid[X][Y]=1;
                else grid[X][Y] = 2;
                X+=x;
                Y+=y;
            }
        }
    }

    private static void lampTurnOFF(int[][] grid, int x, int y) {
        if(grid[x][y]==1) grid[x][y]=0;
        for (int t = 0; t < 8; t++) {
            int i = x+x_dir[t];
            int j = y+y_dir[t];
            if (i >= 0 && i < grid.length && j >= 0 && j < grid.length){
                if(grid[i][j]==1) grid[i][j]=0;
            }
        }
    }

    public static void main(String[] args) {
        int lamps[][]={{0,0},{1,0}};
        int queries[][]={{1,1},{1,1}};
        int n =5;
        int ans[] = grid_Illumination(n, lamps, queries);
        for(int i : ans) System.out.print(i+" ");
    }

    
}

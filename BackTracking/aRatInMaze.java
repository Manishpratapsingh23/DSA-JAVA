public class aRatInMaze {
    private static boolean solve(int[][] maze) {
        int n = maze.length;
        int path[][] = new int[n][n];
        return helper(maze,0,0,path);
        
    }

    private static boolean helper(int[][] maze, int i, int j, int[][] path) {
        if(i<0 || i>=maze.length || j<0 || j>=maze.length || maze[i][j]==0 || path[i][j]==1){
            return false;
        }
        path[i][j]=1;
        if(i==maze.length-1 && j==maze.length-1){
            for(int c=0;c<path.length;c++){
                for(int r=0;r<path.length;r++){
                    System.out.print(path[c][r]+" ");
                }
                System.out.println();
            }
            return true;
        }
        if(helper(maze,i-1,j,path)) return true;
        if(helper(maze,i,j+1,path)) return true;
        if(helper(maze,i+1,j,path)) return true;
        if(helper(maze,i,j-1,path)) return true;
        return false;
    }

    private static void print_valid_paths(int[][] maze, int i, int j, int[][] path) {
        if(i<0 || i>=maze.length || j<0 || j>=maze.length || maze[i][j]==0 || path[i][j]==1){
            return;
        }
        path[i][j]=1;
        if(i==maze.length-1 && j==maze.length-1){
            for(int c=0;c<path.length;c++){
                for(int r=0;r<path.length;r++){
                    System.out.print(path[c][r]+" ");
                }
                System.out.println();
            }
            path[i][j]=0;
            System.out.println("#############################");
            return;
        }
        print_valid_paths(maze,i-1,j,path);
        print_valid_paths(maze,i,j+1,path);
        print_valid_paths(maze,i+1,j,path);
        print_valid_paths(maze,i,j-1,path);
        path[i][j]=0;
    }

    public static void main(String[] args) {
        int maze[][] = {{1,1,0},{1,1,0},{1,1,1}};
        int maze1[][] = {{1,0,1},{1,0,1},{1,1,1}};
        int maze2[][] = {{1,0,1},{1,0,1},{0,1,1}};
        // System.out.println(solve(maze));
        // System.out.println(solve(maze1));
        // System.out.println(solve(maze2));

        print_valid_paths(maze, 0,0,new int[3][3]);
    }

    

    
}

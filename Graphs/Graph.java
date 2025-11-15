import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Intput:
            7
            8
            0 1
            0 2
            3 1
            4 1
            5 3
            5 4
            6 2
            6 5

     (0)
    /   \
  (1)   (2)
  / \     |
(3) (4)  (6)
  \   |  /
   \  | /
    (5)
            
output: DFS traversal : 0 1 3 5 4 6 2
            BFS traversal : 0 1 2 3 4 6 5
 */

public class Graph {
    private static void printHelper_DFS(int edges[][], int sv, boolean visited[]) {
        // Start Vertex=sv
        System.out.print(sv+" ");
        visited[sv] = true;
        int n = edges.length;
        for (int i = 0; i < n; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                printHelper_DFS(edges, i, visited);
            }
        }
    }

    public static void print_DFS(int edges[][]) {
        boolean visited[] = new boolean[edges.length];
        // we have use this for loop because there might be some case when the graph might be some vertices not 
        //connected to each other
        /*
         1 --- 2     4 --- 5
          \   /      
            3
            this type of graph called connected component graph
         */
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printHelper_DFS(edges, i, visited);
            }
        }
    }

    private static void printHelper_BFS(int edges[][], int sv, boolean visited[]) {
        // Start Vertex=sv
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sv);
        visited[sv]=true;
        int n = edges.length;
        while(!queue.isEmpty()){
            try {
                sv=queue.remove();
            } catch (Exception e) {
                return;
            }
            
            System.out.print(sv+" ");
            for (int i = 0; i < n; i++) {
                if (edges[sv][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
            
        }
    }

    public static void print_BFS(int edges[][]) {
        boolean visited[] = new boolean[edges.length];
        // we have use this for loop because there might be some case when the graph might be some vertices not 
        //connected to each other
        /*
         1 --- 2     4 --- 5
          \   /      
            3
            this type of graph called connected component graph

        6
        4
        1 2
        1 3
        2 3
        4 5

         */
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printHelper_BFS(edges, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n= vertices
        int e = sc.nextInt(); // e= edges
        int edges[][] = new int[n][n];

        for (int i = 0; i < e; i++) {
            // first_Vertex = fv, second_Vertex = sv
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        
        // Start DFS traversal
        System.out.print("DFS traversal : ");
        print_DFS(edges);
        System.out.println();

        // Start BFS traversal
        System.out.print("BFS traversal : ");
        print_BFS(edges);
        
        // Close the scanner
        sc.close();
    }
}


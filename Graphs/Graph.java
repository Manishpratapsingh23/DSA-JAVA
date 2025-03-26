import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
            sv=queue.remove();
            
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
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printHelper_BFS(edges, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
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
        System.out.print("BFS traversal : ");
        print_BFS(edges);
        
        // Close the scanner
        sc.close();
    }
}

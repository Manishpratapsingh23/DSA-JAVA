
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * Problem statement
Given an undirected graph G(V,E), find and print all the connected components of the given graph G.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. You need to take input in main and create a function which should return all the connected components. And then print them in the main, not inside function.
Print different components in new line. And each component should be printed in increasing order (separated by space). Order of different components doesn't matter.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Sample Input 1:
4 2
0 1
2 3
Sample Output 1:
0 1 
2 3 
Sample Input 2:
4 3
0 1
1 3 
0 3
Sample Output 2:
0 1 3 
2

 */
public class AllConnectedComponentsGraphs {
    public static void ConnectedVertices(int edges[][]){
        boolean visited[]=new boolean[edges.length];
        for(int i=0;i<edges.length;i++){
            List<Integer> ans=new ArrayList<>();
            if(!visited[i]){
                ConnectedVertices(edges,i,visited,ans);
                Collections.sort(ans); // Sort in increasing order
                for (int node : ans) {
                    System.out.print(node + " ");
                }
                System.out.println();
            }
        }
    }
    private static void ConnectedVertices(int[][] edges, int sv, boolean[] visited, List<Integer> ans) {
        visited[sv]=true;
        ans.add(sv);
        for(int i=0;i<edges.length;i++){
            if(edges[sv][i]==1 && !visited[i]){
                visited[i]=true;
                ConnectedVertices(edges, i, visited,ans);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int edges[][] = new int[v][v];
        for(int i=0;i<e;i++){
            int fv=sc.nextInt();
            int sv=sc.nextInt();
            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }
        ConnectedVertices(edges);
    }
}

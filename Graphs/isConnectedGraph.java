
import java.util.Scanner;
/*
 * Problem statement
Given an undirected graph G(V,E), check if the graph G is connected graph or not.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
true
Sample Input 2:
4 3
0 1
1 3 
0 3
Sample Output 2:
false 
Sample Output 2 Explanation
The graph is not connected, even though vertices 0,1 and 3 are connected to each other 
but there isn’t any path from vertices 0,1,3 to vertex 2. 
*/
public class isConnectedGraph {
    public static void isConnected(int edges[][], int sv, boolean visited[]){
        visited[sv]=true;
        for(int i=0;i<edges.length;i++){
            if(edges[sv][i]==1 && !visited[i]){
                visited[i]=true;
                isConnected(edges, i, visited);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        if(e==0 && v==0){
            System.out.println(true);
            return;
        }
        int edges[][]=new int[v][v];
        for(int i=0;i<e;i++){
            int fv=sc.nextInt();
            int sv=sc.nextInt();
            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }
        boolean visited[]=new boolean[v];
        isConnected(edges,0,visited);
        boolean connected=true;
        for(boolean flag : visited){
            if(!flag){
                connected=false;
                break;
            }
        }
        System.out.println(connected);
    }
}

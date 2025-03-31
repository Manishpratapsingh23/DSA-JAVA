
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/*
 * Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.

Find the path using BFS and print the shortest path available.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
2 <= V <= 1000
1 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= 2^31 - 1
0 <= v2 <= 2^31 - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
3 0 1
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
 */
public class getPath_BFS {
    public static List<Integer> getPathBetweenTwoEdges(int edges[][], int v1, int v2){
        boolean visited[]=new boolean[edges[0].length];
        Queue<Integer> queue=new LinkedList<>();
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> lst=new ArrayList<>();
        queue.add(v1);
        visited[v1] = true;
        boolean flag=false;
        while(!queue.isEmpty()){
            int vertex=queue.remove();
            visited[vertex]=true;
            if(vertex==v2){
                flag = true;
                break;
            }
            for(int i=0;i<edges.length;i++){
                if(edges[vertex][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i]=true;
                    map.put(i,vertex);
                }
            }
        }
        if(flag){
            int temp=v2;
            while(temp!=v1){
                lst.add(temp);
                temp=map.get(temp);
            }
            lst.add(v1);
            return lst;
        }
        return null;
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // int v=sc.nextInt();
        // int e=sc.nextInt();
        // int edges[][]=new int[v][v];
        // for(int i=0;i<e;i++){
        //     int fv=sc.nextInt();
        //     int sv=sc.nextInt();
        //     edges[fv][sv]=1;
        //     edges[sv][fv]=1;
        // }
        // int v1=sc.nextInt();
        // int v2=sc.nextInt();
        int v=4,e=5,v1=1,v2=3;
        int[][] edges = {
            {0, 1, 0, 1},
            {1, 0, 1, 1},
            {0, 1, 0, 1},
            {1, 1, 1, 0}
        };
        
        List<Integer> path = getPathBetweenTwoEdges(edges, v1, v2);

        // Print path in required format
        if (path != null) {
            for (int node : path) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}

/*
 * Problem statement
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. Print true if the path exists and false otherwise.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= 1000
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= V - 1
0 <= v2 <= V - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
true
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
false
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hasPath {

    public static boolean hasPathBetweenTwoEdges(int edges[][], int v1, int v2){
        boolean visited[]=new boolean[edges[0].length];
        return helper(edges,v1,v2,visited);
    }

    private static boolean helper(int edges[][], int v1, int v2, boolean visited[]){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(v1);
        while(!queue.isEmpty()){
            int vertex=queue.remove();
            visited[vertex]=true;
            if(vertex==v2){
                return true;
            }
            for(int i=0;i<edges.length;i++){
                if(edges[vertex][i]==1 && !visited[i]){
                    visited[i]=true;
                    queue.add(i);

                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int edges[][]=new int[v][v];
        for(int i=0;i<e;i++){
            int fv=sc.nextInt();
            int sv=sc.nextInt();
            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }
        int v1=sc.nextInt();
        int v2=sc.nextInt();
        System.out.println(hasPathBetweenTwoEdges(edges,v1,v2));
    }
}

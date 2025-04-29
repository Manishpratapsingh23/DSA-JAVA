/*
 * Problem statement
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.



Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.



For printing MST follow the steps -

1. In one line, print an edge which is part of MST in the format - 
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note: Order of different edges doesn't matter.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
2 <= V, E <= 10^5
1 <= Wi <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Input Graph



Sample Output 1 :
0 1 3
1 2 1
0 3 5
 */

import java.util.Scanner;

public class PrimsAlgorithim {

    private static void prims(int[][] paths) {
        int n=paths.length;
        int parent[]=new int[n];
        boolean visited[]=new boolean[n];
        int weight[]=new int[n];
        parent[0]=-1; 
        weight[0]=0;
        for(int i=1;i<n;i++) weight[i]=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int minVertex=findMinVertex(weight, visited);
            visited[minVertex]=true;
            for(int j=0;j<n;j++){
                if(paths[minVertex][j]!=0 && !visited[j] && paths[minVertex][j] < weight[j]){
                    weight[j]=paths[minVertex][j];
                    parent[j]=minVertex;
                }
            }
        }
        for(int i = 1;i<n;i++)
        {
            if(i< parent[i])
                System.out.println(i+" "+parent[i]+" "+weight[i]);
            else
                System.out.println(parent[i]+" "+i+" "+weight[i]);
                
        }
    }

    private static int findMinVertex(int[] weight, boolean[] visited) {
        int minVertex=-1;
        for(int i=0;i<weight.length;i++){
            if(!visited[i] && (minVertex==-1 || weight[i]<weight[minVertex])){
                minVertex=i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int paths[][]=new int[v][v];
        for(int i=0;i<e;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int weight=sc.nextInt();
            paths[v1][v2]=weight;
            paths[v2][v1]=weight;
        }

        prims(paths);
    }

    

    
}

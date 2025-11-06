
import java.util.Scanner;
/*
 * Problem statement
 * Amazon 
Given an undirected, connected and weighted graph G(V, E) with V number of vertices 
(which are numbered from 0 to V-1) and E number of edges.

Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.

For printing MST follow the steps -

1. In one line, print an edge which is part of MST in the format - 
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note : Order of different edges doesn't matter.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
2 <= V, E <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8

Sample Output 1 :
1 2 1
0 1 3
0 3 5
 */
class Edge implements Comparable<Edge>{
    int source;
    int destination;
    int weight;

    @Override
    public int compareTo(Edge o){
        return this.weight - o.weight;
    }
}

public class KruskalsAlgorithm {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();
        Edge[] input = new Edge[e];
        for(int i=0;i<e;i++) {
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            int weight = sc.nextInt();
            Edge edge = new Edge(); 
            edge.source = sv;
            edge.destination = ev;
            edge.weight = weight;
            input[i] = edge;
        }
        // System.out.println("Graph before sorting: ");
        // print(input);
            
        System.out.println("Graph after sorting: ");
        print(input);
        Edge output[]=Kruskals(input, n);
        System.out.println("MST IS: ");
        print(output);
    }

    public static Edge[] Kruskals(Edge input[], int n){
        Edge[] output = new Edge[n-1];
		int[] parent = new int[n]; 
		for(int i=0;i<parent.length;i++) {
			parent[i] = i; 
		}
        int count=0,i=0;
        while(count<n-1){
            int parent_Source=findParent(parent, input[i].source);
            int parent_Destination=findParent(parent, input[i].destination);
            if(parent_Source==parent_Destination){
                i++;
                continue;
            }
            output[count]=input[i];
            parent[parent_Source]=parent_Destination;
            count++;
            i++;
        }
        return  output;
    }

    private static int findParent(int[] parent, int source) {
        if(parent[source]==source) return source;
        return findParent(parent,parent[source]);
    }

    private static void print(Edge output[]){
        for(Edge edge : output) {
			if(edge.source < edge.destination)
			System.out.println( edge.source +" "+ edge.destination+" "+ edge.weight);
			else {
				System.out.println(edge.destination+" "+ edge.source+" " + edge.weight);
			}
		}
    }
}

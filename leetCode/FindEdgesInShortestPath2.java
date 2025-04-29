import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Edges{
    int u,v,w;
    boolean onPath;
    public Edges(int u, int v, int w){
        this.u=u;
        this.v=v;
        this.w=w;
        onPath=false;
    }
}

public class FindEdgesInShortestPath2 {

    public static void main(String[] args) {
        int n = 6;
        int edges[][]={{0,1,4},{0,2,1},{1,3,2},{1,4,3},{1,5,1},{2,3,1},{3,5,3},{4,5,2}};
        int graph[][]=new int[n][n];

        for(int arr[] : edges){
            int u=arr[0];
            int v=arr[1];
            int w=arr[2];
            graph[u][v]=w;
            graph[v][u]=w;
            //edge.add(new Edges(u,v,w));
        }
        int dist1[]= new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        dist1[0]=0;
        Dijkstras1(graph, n, dist1);
        //print(dist1);

        int dist2[]= new int[n];
        Arrays.fill(dist2,Integer.MAX_VALUE);
        dist2[n-1]=0;
        Dijkstras2(graph, n, dist2);
        //print(dist2);

        boolean ans[]=new boolean[edges.length];
        for(int i=0;i<edges.length;i++){
            int x1=dist1[edges[i][0]];
            int x2=dist1[edges[i][1]];
            int w=edges[i][2];
            int y1=dist2[edges[i][1]];
            int y2=dist2[edges[i][0]];
            if(x1+w+y1==dist1[n-1] || x2+w+y2==dist1[n-1]) ans[i]=true;
        }

        for(boolean b : ans) System.out.print(b+" ");
        
    }

    private static void Dijkstras1(int[][] graph, int v, int dist[]) {
        boolean visited[]=new boolean[v];
        for(int i=0;i<v;i++){
            int source=findMinVertex1(dist,visited);
            visited[source]=true;
            for(int j=0;j<v;j++){
                if (graph[source][j] != 0 && !visited[j] && dist[source] + graph[source][j] < dist[j]) {
                    dist[j] = dist[source] + graph[source][j];
                }
            }
        }
        
    }

    private static void Dijkstras2(int[][] graph, int v, int dist[]) {
        boolean visited[]=new boolean[v];
        for(int i=v-1;i>=0;i--){
            int source=findMinVertex2(dist,visited);
            visited[source]=true;
            for(int j=v-1;j>=0;j--){
                if (graph[source][j] != 0 && !visited[j] && dist[source] + graph[source][j] < dist[j]) {
                    dist[j] = dist[source] + graph[source][j];
                }
            }
        }
    }
    
    private static int findMinVertex1(int[] dist, boolean[] visited) {
        int ans=-1;
        for(int i=0;i<dist.length;i++){
            if(!visited[i] && (ans==-1 || dist[i]<dist[ans])){
                ans=i;
            }
        } return ans;
    }

    private static int findMinVertex2(int[] dist, boolean[] visited) {
        int ans=-1;
        for(int i=dist.length-1;i>=0;i--){
            if(!visited[i] && (ans==-1 || dist[i]<dist[ans])){
                ans=i;
            }
        } return ans;
    }

    private static void print(int dist[]){
        for(int i=0;i<dist.length;i++)
        	System.out.println(i+" "+dist[i]);
    }
}

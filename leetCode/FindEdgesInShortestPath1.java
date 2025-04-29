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

public class FindEdgesInShortestPath1 {

    public static void main(String[] args) {
        Map<Integer, List<Pair>> paths=new HashMap<>();
        List<Edges> edge=new ArrayList<>();
        int n = 6;
        int edges[][]={{0,1,4},{0,2,1},{1,3,2},{1,4,3},{1,5,1},{2,3,1},{3,5,3},{4,5,2}};
        int graph[][]=new int[n][n];
        for(int arr[] : edges){
            int u=arr[0];
            int v=arr[1];
            int w=arr[2];
            graph[u][v]=w;
            graph[v][u]=w;
            edge.add(new Edges(u,v,w));
        }
        boolean visited[]=new boolean[n];
        int dist[]= new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        List<List<Integer>> parents = new ArrayList<>();
        for (int i = 0; i < n; i++) parents.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            int source=findMinVertex(dist,visited);
            visited[source]=true;
            for(int j=0;j<n;j++){
                if (graph[source][j] != 0 && !visited[j] ){
                    int newDist=dist[source] + graph[source][j];
                    if (newDist < dist[j]) {
                        dist[j] = newDist;
                        parents.get(j).clear();
                        parents.get(j).add(source);
                    } else if (newDist == dist[j]) {
                        parents.get(j).add(source);
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            markEdgesInPath(i, parents, edge, graph);
        }
        // && dist[source] + graph[source][j] < dist[j]) {
        //     dist[j] = dist[source] + graph[source][j];
        //     markEdgeTrue(source,j,graph[source][j],edge);
        for(Edges e : edge)
           System.out.print(e.onPath+" ");
    }
    
    private static int findMinVertex(int[] dist, boolean[] visited) {
        int ans=-1;
        for(int i=0;i<dist.length;i++){
            if(!visited[i] && (ans==-1 || dist[i]<dist[ans])){
                ans=i;
            }
        } return ans;
    }

    private static void markEdgeTrue(int u, int v, int w, List<Edges> edge) {
        for (Edges e : edge) {
            if (((e.u == u && e.v == v) || (e.u == v && e.v == u)) && e.w == w) {
                e.onPath = true;
                return;
            }
        }
    }

    private static void markEdgesInPath(int node, List<List<Integer>> parents, List<Edges> edge, int[][] graph) {
        for (int parent : parents.get(node)) {
            markEdgeTrue(node, parent, graph[node][parent], edge);
            markEdgesInPath(parent, parents, edge, graph); // Recursive trace back
        }
    }
}


import java.util.Arrays;
import java.util.Scanner;

public class DijkstrasAlgorithim {

    private static void Dijkstras(int[][] graph, int v) {
        boolean visited[]=new boolean[v];
        int dist[]=new int[v];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        for(int i=0;i<v;i++){
            int source=findMinVertex(dist,visited);
            visited[source]=true;
            for(int j=0;j<v;j++){
                if (graph[source][j] != 0 && !visited[j] && dist[source] + graph[source][j] < dist[j]) {
                    dist[j] = dist[source] + graph[source][j];
                }
            }
        }
        for(int i=0;i<v;i++)
        	System.out.println(i+" "+dist[i]);
    }

    private static int findMinVertex(int[] dist, boolean[] visited) {
        int ans=-1;
        for(int i=0;i<dist.length;i++){
            if(!visited[i] && (ans==-1 || dist[i]<dist[ans])){
                ans=i;
            }
        } return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int graph[][]=new int[v][v];
        while(e>0){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int weight=sc.nextInt();
            graph[v1][v2]=weight;
            graph[v2][v1]=weight;
            e--;
        }
        Dijkstras(graph,v);
    }
}

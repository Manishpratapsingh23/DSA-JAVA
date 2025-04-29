import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair{
    int node;
    int weight;
    public Pair(int node, int weight){
        this.node=node;
        this.weight=weight;
    }
}

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
public class FindEdgesInShortestPath {
   // public int fd=0;
    private static void addEdge(Map<Integer, List<Pair>> paths, int u, int v, int w) {
        paths.putIfAbsent(u, new ArrayList<>());
        paths.putIfAbsent(v, new ArrayList<>());

        paths.get(u).add(new Pair(v, w));
        paths.get(v).add(new Pair(u, w));
    }

    private static int find(int n, Map<Integer, List<Pair>> paths, boolean visited[],int node, int distance, boolean ans[], List<Edges> edge) {
        if(node==n-1){
            ans[n-1]=true;
            return distance;
        }
        int prevDist=Integer.MAX_VALUE;
        boolean res[]=new boolean[n];
        visited[node]=true;
        for(Pair p : paths.get(node)){
            if(!visited[p.node]){
            int d=find(n, paths, visited, p.node, distance+p.weight, ans, edge);
            if(d<prevDist){
                prevDist=d;
                System.arraycopy(ans, 0, res, 0, n);
                marksEdgeTrue(node,p.node,p.weight,edge);
            }
            else if (d == prevDist) {
                // multiple shortest paths
                for (int i = 0; i < n; i++) {
                    res[i] = res[i] || ans[i];
                }
                marksEdgeTrue(node, p.node, p.weight, edge);
            }
        }
        }
        visited[node] = false;
     for(int i = 0; i < n; i++) {
        ans[i] = res[i];
     }
        return prevDist;
    }
    

    public static void main(String[] args) {
        Map<Integer, List<Pair>> paths=new HashMap<>();
        List<Edges> edge=new ArrayList<>();
        int n = 6;
        int edges[][]={{0,1,4},{0,2,1},{1,3,2},{1,4,3},{1,5,1},{2,3,1},{3,5,3},{4,5,2}};
        for(int arr[] : edges){
            edge.add(new Edges(arr[0] , arr[1], arr[2]));
            addEdge(paths,arr[0] , arr[1], arr[2]);
        }
        boolean visited[]=new boolean[n];
        boolean ans[]= new boolean[n];
        int res=find(n,paths,visited,0,0,ans,edge);
        System.out.println(res);
        for(Edges e : edge)
           System.out.print(e.onPath+" ");
    }

    private static void marksEdgeTrue(int node, int node0, int weight, List<Edges> edge) {
        for (Edges e : edge) {
            if (((e.u == node && e.v == node0) || (e.u == node0 && e.v == node)) && e.w == weight) {
                e.onPath = true;
                return;
            }
        }
    }
    
}

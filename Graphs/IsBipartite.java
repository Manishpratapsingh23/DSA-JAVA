
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class IsBipartite {
    public static void main(String[] args) {
        int edges[][] = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(edges));
    }
    public static boolean isBipartite(int[][] graph) {
        Queue<pair> q = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        for(int key=0;key<graph.length;key++){
            if(visited.containsKey(key)) continue;
            q.add(new pair(key,0));
            while(!q.isEmpty()){
                pair src = q.remove();
                if(visited.containsKey(src.vtx)){
                    if(src.distance != visited.get(src.vtx)) return false;
                    continue;
                }
                visited.put(src.vtx, src.distance);
                for(int nbrs : graph[src.vtx]){
                    if(!visited.containsKey(nbrs)){  
                        q.add(new pair(nbrs, src.distance+1));
                    }
                }
            }
        }
        return true;
    }
}
class pair{
    int vtx;
    int distance;
    public pair(int vtx, int distance){
        this.vtx = vtx;
        this.distance = distance;
    }
}


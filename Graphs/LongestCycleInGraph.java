
import java.util.*;

public class LongestCycleInGraph {
    public int longestCycle(int[] edges) {
       int in[] = new int[edges.length];
        for(int i=0;i<edges.length;i++){
            if(edges[i]!=-1) in[edges[i]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<edges.length;i++){
            if(in[i]==0) q.add(i);
        }
        Set<Integer> visited = new HashSet<>();
        while(!q.isEmpty()){
            int e = q.poll();
            visited.add(e);
            if(edges[e]!=-1) in[edges[e]]--;
            if(edges[e]!=-1 && in[edges[e]]==0) q.add(edges[e]);
        }
        int ans = -1;
        for(int i=0;i<edges.length;i++){
            if(!visited.contains(i)){
                int c = 1;
                int nbrs = edges[i];
                visited.add(i);
                while(nbrs!=i){
                    c++;
                    visited.add(nbrs);
                    nbrs = edges[nbrs];
                }
                ans = Math.max(ans,c);
            }
        }
        return ans; 
    }
    public static void main(String[] args) {
        int edges[] = {3,3,4,2,3};
        LongestCycleInGraph ob = new LongestCycleInGraph();
        System.out.println(ob.longestCycle(edges));
    }
}

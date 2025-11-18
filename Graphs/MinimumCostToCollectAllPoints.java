import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
class PrimsPair{
    int v1;
    int v2;
    int cost;
    public PrimsPair(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}
public class MinimumCostToCollectAllPoints {

    Map<Integer, Map<Integer, Integer>> map;
    public int minCostConnectPoints(int[][] points) {
        map = new HashMap<>();
        for(int i=0;i<points.length;i++) map.put(i,new HashMap<>());
        for(int i=0;i<points.length-1;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=i+1;j<points.length;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int cost = Math.abs(x1-x2)+Math.abs(y1-y2);
                map.get(i).put(j,cost);
                map.get(j).put(i,cost);
            }
        }
        PriorityQueue<PrimsPair> pq = new PriorityQueue<>(new Comparator<PrimsPair>(){
            @Override
            public int compare(PrimsPair o1, PrimsPair o2){
                return o1.cost-o2.cost;
            }
        });
        Set<Integer> visited = new HashSet<>();
        pq.add(new PrimsPair(0, 0, 0));
        int ans = 0;
        while(!pq.isEmpty()){
            PrimsPair pp = pq.remove();
            if(visited.contains(pp.v1)) continue;
            visited.add(pp.v1);
            ans+=pp.cost;
            for(int nbrs : map.get(pp.v1).keySet()){
                if(!visited.contains(nbrs)){
                    int cost = map.get(pp.v1).get(nbrs);
                    pq.add(new PrimsPair(nbrs, pp.v1, cost));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        MinimumCostToCollectAllPoints ob = new MinimumCostToCollectAllPoints();
        int points[][] = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(ob.minCostConnectPoints(points));
    }
}
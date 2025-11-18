import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstrasAlgorithimMonuBhaiya {
    Map<Integer, Map<Integer, Integer>> map;

    public DijkstrasAlgorithimMonuBhaiya(int v){
        map = new HashMap<>();
        for(int i=0;i<v;i++) map.put(i, new HashMap<>());
    }

    public void addEdge(int v1, int v2, int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }

    public int Dijkstras(){
        PriorityQueue<pair> pq = new PriorityQueue<>(new Comparator<pair>(){
            @Override
            public int compare(pair p1, pair p2){
                return p1.cost-p2.cost;
            }
        });
    }
}
class pair{
    int v1;
    int v2;
    int cost;
    public pair(int v1, int v2, int cost){
        this.v1=v1;
        this.v2=v2;
        this.cost=cost;
    }
}

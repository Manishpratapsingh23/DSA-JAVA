import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class DijkstrasAlgorithimMonuBhaiya {
    Map<Integer, Map<Integer, Integer>> map;

    public DijkstrasAlgorithimMonuBhaiya(int v){
        map = new HashMap<>();
        for(int i=1;i<=v;i++) map.put(i, new HashMap<>());
    }

    public void addEdge(int v1, int v2, int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);   
    }

    public void Dijkstras(int v){
        PriorityQueue<DijkstrasPair> pq = new PriorityQueue<>(new Comparator<DijkstrasPair>(){
            @Override
            public int compare(DijkstrasPair p1, DijkstrasPair p2){
                return p1.cost-p2.cost;
            }
        });

        pq.add(new DijkstrasPair(v, Integer.toString(v),0));
        Set<Integer> visited = new HashSet<>();
        while(!pq.isEmpty()){
            //1. remove  2. ignore  3. add  4. selft work  5. add unvisited DijkstrasPair
            DijkstrasPair p = pq.remove();
            if(visited.contains(p.vtx)) continue;
            visited.add(p.vtx);
            System.out.println(p);
            for(int nbrs : map.get(p.vtx).keySet()){
                if(!visited.contains(nbrs)){
                    int cost = map.get(p.vtx).get(nbrs)+p.cost;
                    pq.add(new DijkstrasPair(nbrs, p.path+" "+nbrs, cost));
                }
            }            
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        DijkstrasAlgorithimMonuBhaiya dj = new DijkstrasAlgorithimMonuBhaiya(v);

        for(int i=0;i<e;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            dj.addEdge(v1, v2, cost);
        }
        int source = sc.nextInt();
        dj.Dijkstras(source);
    }
}
class DijkstrasPair{
    int vtx;
    String path;
    int cost;
    public DijkstrasPair(int vtx, String path, int cost){
        this.vtx=vtx;
        this.path=path;
        this.cost=cost;
    }
    @Override
    public String toString(){
        return vtx+": "+path+" and cost: "+cost;
    } 
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
// 5
// 7
// 1 2 8
// 1 3 4
// 1 4 5
// 2 5 -2
// 5 2 1
// 3 4 -3
// 4 5 4
public class BellmanFordAlgorithimMonuBhaiya {
    Map<Integer, Map<Integer, Integer>> map;

    public BellmanFordAlgorithimMonuBhaiya(int v){
        map = new HashMap<>();
        for(int i=1;i<=v;i++) map.put(i, new HashMap<>());
    }

    public void addEdge(int v1, int v2, int cost){
        map.get(v1).put(v2,cost);
        //map.get(v2).put(v1,cost);   
    }

    class EdgePair{
        int e1;
        int e2;
        int cost;
        public EdgePair(int e1, int e2, int cost){
            this.e1 = e1;
            this.e2 = e2;
            this.cost = cost;
        }

        public String toString(){
            return e1+" "+e2+" "+" @"+cost;
        }
    }

    public List<EdgePair> getAllEdges(){
        List<EdgePair> ll = new ArrayList<>();
        for(int e1 : map.keySet()){
            for(int e2 : map.get(e1).keySet()){
                int cost = map.get(e1).get(e2);
                ll.add(new EdgePair(e1, e2, cost));
            }
        }
        return ll;
    }

    public void BellmanFord(){
        int v = map.size();
        int dist[] = new int[v+1];
        for(int i=2;i<=v;i++) dist[i] = 9999999;
        List<EdgePair> ll = getAllEdges();
        for(int i=1;i<=v;i++){
            for(EdgePair e : ll){
                if(i==v && dist[e.e2]>dist[e.e1]+e.cost){
                   System.out.println("-wt Cycle");
                   return;  
                }
                if(dist[e.e2]>dist[e.e1]+e.cost){
                    dist[e.e2] = dist[e.e1] + e.cost;
                }
            }
        }

        for(int i=1;i<=v;i++){
            System.out.println(dist[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        BellmanFordAlgorithimMonuBhaiya bm = new BellmanFordAlgorithimMonuBhaiya(v);
        int e = sc.nextInt();
        for(int i=1;i<=e;i++){
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();
            int cost = sc.nextInt();
            bm.addEdge(e1, e2, cost);
        }
        bm.BellmanFord();
    }
}

import java.util.*;

public class PrimsAlgorithimMonuBhaiya {
    Map<Integer, Map<Integer, Integer>> map;
    public PrimsAlgorithimMonuBhaiya(int v) {
        map = new HashMap<>();
        for(int i=1;i<=v;i++){
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }

    class PrimsPair{
        int vtx;
        int acqVtx;
        int cost;
        public PrimsPair(int vtx, int acqVtx, int cost){
            this.vtx = vtx;
            this.acqVtx = acqVtx;
            this.cost = cost;
        }

        public String toString(){
            return vtx+" "+acqVtx+" "+" @"+cost;
        }
    }
    public int prims(){
        PriorityQueue<PrimsPair> pq = new PriorityQueue<>(new Comparator<PrimsPair>(){
            @Override
            public int compare(PrimsPair o1, PrimsPair o2){
                return o1.cost-o2.cost;
            }
        });
        Set<Integer> visited = new HashSet<>();
        pq.add(new PrimsPair(1,1,0));
        int sum = 0;
        while(!pq.isEmpty()){
            //1. remove
            PrimsPair pair = pq.remove();
            //2. ignore
            if(visited.contains(pair.vtx)) continue;
            //3. Mark Visited
            visited.add(pair.vtx);
            //4. self work
            sum+=pair.cost;
            System.out.println(pair);
            for(int nbrs : map.get(pair.vtx).keySet()){
                if(!visited.contains(nbrs)){
                    int cost = map.get(pair.vtx).get(nbrs);
                    pq.add(new PrimsPair(nbrs, pair.vtx, cost));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        PrimsAlgorithimMonuBhaiya pp = new PrimsAlgorithimMonuBhaiya(v);
        int e = sc.nextInt();
        for(int i=1;i<=e;i++){
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();
            int cost = sc.nextInt();
            pp.addEdge(e1, e2, cost);
        }

        System.out.println(pp.prims());
    }

}

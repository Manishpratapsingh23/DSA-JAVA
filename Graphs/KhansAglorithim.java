import java.util.*;
public class KhansAglorithim {
    Map<Integer,List<Integer>> map;
    public List<Integer> khansAlgo(int v, int edges[][]){
        map = new HashMap<>();
        for(int i=0;i<=v;i++) map.put(i, new ArrayList<>());
        for(int arr[] : edges) map.get(arr[0]).add(arr[1]);

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int in[] = new int[v+1];
        for(int arr[] : edges) in[arr[1]]++;
        for(int i=0;i<=v;i++) if(in[i]==0) q.add(i);
        while(!q.isEmpty()){
            int vtx = q.remove();
            ans.add(vtx);
            for(int nbrs : map.get(vtx)){
                in[nbrs]-=1;
                if(in[nbrs]==0) q.add(nbrs);
            }
        }
        return ans;
    }

    public static void main(String agrs[]){
        int n = 5;
        int edges[][] = {{0,1},{4,5},{5,1},{1,2},{5,2},{2,3}};
        KhansAglorithim ob = new KhansAglorithim();
        System.out.println(ob.khansAlgo(n,edges));
    }
}

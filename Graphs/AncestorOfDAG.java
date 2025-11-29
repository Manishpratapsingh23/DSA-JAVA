import java.util.*;
public class AncestorOfDAG {
    Map<Integer,List<Integer>> map;
    public List<List<Integer>> getAncestors(int v, int[][] edges){
    	List<Set<Integer>> ans = new ArrayList<>();
        map = new HashMap<>();
        for(int i=0;i<v;i++){
        	map.put(i, new ArrayList<>());
        	ans.add(new HashSet<>());
        }
        int in[] = new int[v];
        for(int arr[] : edges){
        	in[arr[1]]++;
        	map.get(arr[0]).add(arr[1]);
        	//map.get(arr[1]).add(arr[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
        	if(in[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
        	int vtx = q.remove();
        	for(int nbrs : map.get(vtx)){
        		ans.get(nbrs).add(vtx);
        		ans.get(nbrs).addAll(ans.get(vtx));
        		if(--in[nbrs]==0) q.add(nbrs);
        	}
        }
        List<List<Integer>> res = new ArrayList<>();
        for(Set<Integer> set : ans){
        	List<Integer> lst = new ArrayList<>(set);
        	Collections.sort(lst);
        	res.add(lst);
        }
        return res;

        
    }

    public static void main(String agrs[]){
        int n = 8;
        int edges[][] = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        AncestorOfDAG ob = new AncestorOfDAG();
        System.out.println(ob.getAncestors(n,edges));
    }
}

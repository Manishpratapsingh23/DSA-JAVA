import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphValidTree {
    public static void main(String[] args) {
        int edges[][] = {{0,1},{0,2},{0,3},{1,4}};
		int n = 5;
		System.out.println(validTree(n, edges));
    }


    private static boolean validTree(int n, int edges[][]){
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i=0;i<n;i++) map.put(i, new ArrayList<>());
		for(int arr[] : edges){
			int v1 = arr[0];
			int v2 = arr[1];
			map.get(v1).add(v2);
			map.get(v2).add(v1);
		}
		return BFT(n, map);
	}

	private static boolean BFT(int n, Map<Integer, List<Integer>> map){
		Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
		int c = 0;
		for(int key : map.keySet()){
            if(visited.contains(key)) continue;
			c++;
            q.add(key);
            while(!q.isEmpty()){
                // 1. remove
                int src = q.remove();
                //2. ignore
                if(visited.contains(src)) return false;
                //3. add visited
                visited.add(src);
                //4. self work
                System.out.println(src);
                //5. add unvisited nbrs
                for(int nbrs : map.get(src)){
                    if(!visited.contains(nbrs)) q.add(nbrs);
                }
            }
        }
		return c==1;
	}
}

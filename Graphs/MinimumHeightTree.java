import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumHeightTree {
    public static void main(String[] args) {
        int n = 6;
        int edges[][] = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        System.out.println(findMinHeightTrees1(n, edges));

    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(i,new ArrayList<>());
        for(int arr[] : edges){
            int s = arr[0];
            int v = arr[1];
            map.get(s).add(v);
            map.get(v).add(s);
        }
        List<Integer> ans = new ArrayList<>();
        int minHeight = n;
        for(int i=0;i<n;i++){
            int h = helper(map, i);
            if(minHeight==h) ans.add(i);
            else if(h<minHeight){
                ans.clear();
                ans.add(i);
                minHeight = h;
            }
        }
        return ans;
        
    }
    public static List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(i,new ArrayList<>());
        int in[] = new int[n];
        for(int arr[] : edges){
            int u = arr[0];
            int v = arr[1];
            map.get(u).add(v);
            map.get(v).add(u);
            in[u]++;
            in[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<n;i++){
            if(in[i]==1) q.add(i);
        }
        int processed = 0;
        while(n-processed>2){
            int s = q.size();
            processed += s;
            for(int i=0;i<s;i++){
                int v = q.remove();
                for(int nbrs : map.get(v)){
                    if(!visited.contains(nbrs)){
                        if(--in[nbrs]==1) q.add(nbrs);
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.addAll(q);
        return ans;
    }

    private static int helper(Map<Integer, List<Integer>> map, int root){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        int h = 0;
        while(!q.isEmpty()){
            int s = q.size();
            h++;
            for(int i=0;i<s;i++){
                int src = q.remove();
                if(visited.contains(src)) continue;
                visited.add(src);
                for(int nbrs : map.get(src)){
                    if(!visited.contains(nbrs)) q.add(nbrs);
                }
            }
        }
        return h;
    }
    
}

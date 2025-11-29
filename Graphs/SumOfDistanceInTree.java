import java.util.*;
public class SumOfDistanceInTree{
    public static int[] sumOfDistancesTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(i,new ArrayList<>());
        for(int arr[] : edges){
            int u = arr[0];
            int v = arr[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = dfs(i,map,new HashSet<>());
        }
        return ans;
    }

    private static int dfs(int src, Map<Integer, List<Integer>> map, Set<Integer> visited){
        if(visited.contains(src)) return 0;
        visited.add(src);
        int ans = 0;
        for(int nbrs : map.get(src)){
            if(!visited.contains(nbrs)) 
                ans+=dfs(nbrs, map, visited);
        }
        return 2*ans+1;
    }

    public static void main(String agrs[]){
        int n = 6;
        int edges[][] = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        int ans[] = sumOfDistancesTree(n,edges);
        for(int i : ans) System.out.print(i+" ");
    }
}
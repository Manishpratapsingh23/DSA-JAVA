import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CollectCoinsInATree {
    public static int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(i, new ArrayList<>());
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
        int removed_node = 0;
        for(int i=0;i<n;i++){
            if(in[i]==1 && coins[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int v = q.remove();
            removed_node++;
            for(int nbrs : map.get(v)){
                if(--in[nbrs]==1 && coins[nbrs]==0) q.add(nbrs);
            }
        }


        for(int i=0;i<n;i++){
            if(in[i]==1 && coins[i]==1) q.add(i);
        }
        for(int t=0;t<2;t++){
            int size = q.size();
            while(size-- > 0){
                int v = q.remove();
                removed_node++;
                for(int nbrs : map.get(v)){
                    if(--in[nbrs]==1) q.add(nbrs);
                }
            }
        }



        int remaining = n-removed_node;
        if(remaining<=1) return 0;
        return (remaining-1)*2;

    }

    public static void main(String[] args) {
        int coins[] = {1,0,0,0,0,1};
        int edges[][] = {{0,1},{1,2},{2,3},{3,4},{4,5}};
        System.out.println(collectTheCoins(coins, edges));
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class RedundantConnectionII {
    Map<Integer,List<Integer>> map;
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        map = new HashMap<>();
        for(int i=1;i<edges.length;i++) map.put(i, new ArrayList<>());
        for(int arr[] : edges){
            map.get(arr[0]).add(arr[1]);
        }

        for(int v : map.keySet()){
            CreatSet(v);
        }
        List<int[]> ans = new ArrayList<>();
        for(int arr[] : edges){
            int e1 = arr[0];
            int e2 = arr[1];
            int re1 = find(e1);
            int re2 = find(e2);
            if(re1==re2){
                ans.add(arr);
            } else {
                union(e1, e2);
            }
        }
        return ans.get(ans.size()-1);
    }

    Map<Integer, Node> nodeMap = new HashMap<>();
    class Node{
        int data;
        Node parent;
        int rank;
    }

    public void CreatSet(int v){
        Node nn = new Node();
        nn.data = v;
        nn.parent = nn;
        nn.rank = 0;
        nodeMap.put(v,nn);
    }

    public int find(int v){
        Node nn = nodeMap.get(v);
        return find(nn).data;
    }

    public Node find(Node nn){
        if(nn.parent==nn) return nn;
        Node n = find(nn.parent);
        nn.parent = n;
        return n;
    }

    public void union(int v1, int v2){
        Node nn1 = nodeMap.get(v1);
        Node nn2 = nodeMap.get(v2);
        Node rn1 = find(nn1);
        Node rn2 = find(nn2);

        if(rn1.rank==rn2.rank){
            rn1.parent = rn2;
            rn2.rank++;
        } else if(rn1.rank > rn2.rank){
            rn2.parent = rn1;
        } else {
            rn1.parent = rn2;
        }
    }



    public static void main(String[] args) {
        int edges[][] =  {{1,2},{2,3},{3,4},{4,1},{1,5}};
        RedundantConnectionII ob  = new RedundantConnectionII();
        int ans[] = ob.findRedundantDirectedConnection(edges);
        System.out.println(ans[0]+" "+ans[1]);
    }
}

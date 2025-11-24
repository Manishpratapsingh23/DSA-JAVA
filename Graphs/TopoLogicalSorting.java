import java.util.*;
public class TopoLogicalSorting {
    Map<Integer,List<Integer>> map;
    public List<Integer> TopoLogical(int v, int edges[][]){
        map = new HashMap<>();
        for(int i=0;i<=v;i++) map.put(i, new ArrayList<>());
        for(int arr[] : edges) map.get(arr[0]).add(arr[1]);

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<=v;i++){
            dfs(i,visited,stack);
        }
        List<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }

    private void dfs(int v, Set<Integer> visited, Stack<Integer> stack){
        if(visited.contains(v)) return;
        visited.add(v);
        for(int nbrs : map.get(v)) dfs(nbrs,visited,stack);
        stack.push(v);
        return;
    }

    public static void main(String agrs[]){
        int n = 5;
        int edges[][] = {{5,0},{4,0},{5,2},{4,1},{3,1},{2,3}};
        TopoLogicalSorting ob = new TopoLogicalSorting();
        System.out.println(ob.TopoLogical(n,edges));
    }
}

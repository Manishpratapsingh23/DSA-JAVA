
import java.util.*;

public class CourseScheduleII {
    public static int[] findOrder(int courses, int[][] prerequisites) {
        int ans[] = new int[courses];
        int in[] = new int[courses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<courses;i++) map.put(i, new ArrayList<>());
        for(int arr[] : prerequisites){
            int u = arr[0];
            int v = arr[1];
            map.get(u).add(v);
            in[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<courses;i++){
            if(in[i]==0) q.add(i);
        }

        int idx = courses-1;
        while(!q.isEmpty()){
            int vtx = q.remove();
            if(visited.contains(vtx)) continue;
            visited.add(vtx);
            ans[idx--] = vtx;
            for(int nbrs : map.get(vtx)){
                if(!visited.contains(nbrs)){
                    //q.add(nbrs);
                    in[nbrs]--;
                    if(in[nbrs]==0) q.add(nbrs);
                }
            }
            
        }

        return ans;
    }

    public static void main(String args[]){
        int n = 4;
        int courses[][] = {{1,0},{2,0},{3,1},{3,2}};
        int ans[] = findOrder(n,courses);
        for(int i : ans) System.out.print(i+" ");
    }
}

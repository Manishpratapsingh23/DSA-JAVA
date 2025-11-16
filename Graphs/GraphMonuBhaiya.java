
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphMonuBhaiya {
    Map<Integer, Map<Integer, Integer>> map;
    public GraphMonuBhaiya(int v) {
        map = new HashMap<>();
        for(int i=1;i<=v;i++){
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int cost){
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }

    public boolean containsEdge(int v1, int v2){
        return map.get(v1).containsKey(v2);
    }

    public boolean containsVertex(int v){
        return map.containsKey(v);
    }

    public int noOfedge(){
        int count = 0;
        for(int vertex : map.keySet()){
            count += map.get(vertex).size();
        }
        return count/2;
    }

    public void removeEdge(int v1, int v2){
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }

    public void removeVertex(int v){
        for(int nbrs : map.get(v).keySet()){
            map.get(nbrs).remove(v);
        }
        map.remove(v);
    }

    public void display(){
        for(int key : map.keySet()){
            System.out.println(key+" "+map.get(key));
        }
    }

    public boolean hasPath(int src, int des, Set<Integer> visited){
        if(src==des) return true;
        visited.add(src);
        for(int nbrs : map.get(src).keySet()){
            if(!visited.contains(nbrs)){
                if(hasPath(nbrs, des, visited)) return true;
            }
        }
        return false;
    }

    public void printAllPath(int src, int des, Set<Integer> visited, String path){
        if(src==des){
            System.out.println(path+des);
            return;
        }
        visited.add(src);
        for(int nbrs : map.get(src).keySet()){
            if(!visited.contains(nbrs)){
                printAllPath(nbrs, des, visited, path+src);
            }
        }
        visited.remove(src);
    }

    public boolean BFS(int src, int des){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        Set<Integer> visited = new HashSet<>();
        while(!q.isEmpty()){
            // 1. remove
            src = q.remove();
            //2. ignore
            if(visited.contains(src)) continue;
            //3. add visited
            visited.add(src);
            //4. self work
            if(src==des) return true;
            //5. add unvisited nbrs
            for(int nbrs : map.get(src).keySet()){
                if(!visited.contains(nbrs)) q.add(nbrs);
            }
        }
        return false;
    }

    public boolean DFS(int src, int des){
        Stack<Integer> s = new Stack<>();
        s.push(src);
        Set<Integer> visited = new HashSet<>();
        while(!s.isEmpty()){
            // 1. remove
            src = s.pop();
            //2. ignore
            if(visited.contains(src)) continue;
            //3. add visited
            visited.add(src);
            //4. self work
            if(src==des) return true;
            //5. add unvisited nbrs
            for(int nbrs : map.get(src).keySet()){
                if(!visited.contains(nbrs)) s.push(nbrs);
            }
        }
        return false;
    }

    public void BFT(){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for(int key : map.keySet()){
            if(visited.contains(key)) continue;

            q.add(key);
            while(!q.isEmpty()){
                // 1. remove
                int src = q.remove();
                //2. ignore
                if(visited.contains(src)) continue;
                //3. add visited
                visited.add(src);
                //4. self work
                System.out.println(src);
                //5. add unvisited nbrs
                for(int nbrs : map.get(src).keySet()){
                    if(!visited.contains(nbrs)) q.add(nbrs);
                }
            }
        }
    }

    public void DFT(){
        Stack<Integer> s = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        for(int key : map.keySet()){
            if(visited.contains(key)) continue;

            s.push(key);
            while(!s.isEmpty()){
                // 1. remove
                int src = s.pop();
                //2. ignore
                if(visited.contains(src)) continue;
                //3. add visited
                visited.add(src);
                //4. self work
                System.out.println(src);
                //5. add unvisited nbrs
                for(int nbrs : map.get(src).keySet()){
                    if(!visited.contains(nbrs)) s.push(nbrs);
                }
            }
        }
    }
}

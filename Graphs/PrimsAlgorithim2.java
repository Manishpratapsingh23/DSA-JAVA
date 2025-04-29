
import java.util.*;

class Edge implements Comparable<Edge> {
    int vertex;
    int weight;

    public Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class PrimsAlgorithim2 {

    public static void prims(int v, List<List<int[]>> adj) {
        boolean[] visited = new boolean[v];
        int[] parent = new int[v];
        int[] weight = new int[v];

        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[0] = 0;
        parent[0] = -1;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int u = curr.vertex;

            if (visited[u]) continue;
            visited[u] = true;

            for (int[] neighbor : adj.get(u)) {
                int vtx = neighbor[0];
                int wt = neighbor[1];

                if (!visited[vtx] && wt < weight[vtx]) {
                    weight[vtx] = wt;
                    parent[vtx] = u;
                    pq.offer(new Edge(vtx, wt));
                }
            }
        }

        for (int i = 1; i < v; i++) {
            int u = parent[i];
            int vtx = i;
            int wt = weight[i];
            if (u < vtx)
                System.out.println(u + " " + vtx + " " + wt);
            else
                System.out.println(vtx + " " + u + " " + wt);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int vtx = sc.nextInt();
            int wt = sc.nextInt();
            adj.get(u).add(new int[]{vtx, wt});
            adj.get(vtx).add(new int[]{u, wt});
        }

        prims(v, adj);
    }
}

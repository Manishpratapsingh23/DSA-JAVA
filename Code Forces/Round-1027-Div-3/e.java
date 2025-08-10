import java.io.*;
import java.util.*;

public class e {
    static ArrayList<Integer>[] tree;
    static int[] a;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            a = new int[n];
            String[] parts = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(parts[i]);
            }

            // Build tree
            tree = new ArrayList[n];
            for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                String[] edge = br.readLine().split(" ");
                int u = Integer.parseInt(edge[0]) - 1;
                int v = Integer.parseInt(edge[1]) - 1;
                tree[u].add(v);
                tree[v].add(u);
            }

            // Compute parent and depth for each node
            parent = new int[n];
            depth = new int[n];
            Arrays.fill(parent, -1);
            dfs(0, -1, 0);

            // For each node, walk up to root and compute max alternating sum
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int cur = 0;
                int sign = 1;
                int x = i;
                int maxSum = Integer.MIN_VALUE;
                while (x != -1) {
                    cur += sign * a[x];
                    if (cur > maxSum) maxSum = cur;
                    sign *= -1;
                    x = parent[x];
                }
                sb.append(maxSum).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    static void dfs(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        for (int v : tree[u]) {
            if (v != p) {
                dfs(v, u, d + 1);
            }
        }
    }
}

import java.util.HashSet;

public class GraphMonuBhaiyaUse {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphMonuBhaiya g = new GraphMonuBhaiya(7);
		g.addEdge(1, 4, 5);
		g.addEdge(1, 2, 3);	
		g.addEdge(3, 2, 4);
		g.addEdge(3, 4, 2);
		g.addEdge(5, 4, 6);
		g.addEdge(5, 6, 1);
		g.addEdge(5, 7, 8);
		g.addEdge(7, 6, 4);
		g.display();
		// System.out.println(g.HasPath(1, 6,new HashSet<>()));
		// g.PrintPath(1, 6, new HashSet<>(), "");

		//System.out.println(g.hasPath(1, 6, new HashSet<>()));
		//g.printAllPath(1, 6, new HashSet<>(), "");
		//System.out.println(g.BFS(1, 6));
		System.out.println(g.DFS(1, 6));
	}
}

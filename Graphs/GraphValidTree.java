public class GraphValidTree {
    public static void main(String[] args) {
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
    }
}

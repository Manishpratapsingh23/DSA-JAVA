import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// this representation is only for undirected graph
public class GraphRepresentation {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] adjMatrix = adjaencyMatrix(sc);
        List<List<Integer>> adjList = adjaencyList(sc);
        List<Edges> edgeList = edgeOfList(sc);
    }

    

    private static int[][] adjaencyMatrix(Scanner sc) {
        int v = sc.nextInt();
        int e = sc.nextInt();
        int edges[][] = new int[v][v];
        for(int i=0;i<e;i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            edges[source][destination] = 1;
            edges[destination][source] = 1;
        }
        return edges;
    }


    private static List<List<Integer>> adjaencyList(Scanner sc) {
        List<List<Integer>> adjList = new ArrayList<>();
        int v = sc.nextInt();
        int e = sc.nextInt();
        for(int i=0;i<v;i++) adjList.add(new ArrayList<>());
        for(int i=0;i<e;i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            adjList.get(source).add(destination);
            adjList.get(destination).add(source);
        }
        return adjList;
    }

    private static List<Edges> edgeOfList(Scanner sc) {
        List<Edges> edgeList = new ArrayList<>();
        int v = sc.nextInt();
        int e = sc.nextInt();
        for(int i=0;i<e;i++){
            int source = sc.nextInt();
            int destination = sc.nextInt() ;
            edgeList.add(new Edges(source, destination));
        }
        return edgeList;
    }

    static class Edges{
        int source;
        int destination;

        public Edges(int source, int destination){
            this.source = source;
            this.destination = destination;
        }
    }

}

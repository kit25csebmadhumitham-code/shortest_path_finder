import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int vertices;
    private List<List<Edge>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {

        adjacencyList.get(source).add(
            new Edge(destination, weight)
        );

        // For an undirected graph
        adjacencyList.get(destination).add(
            new Edge(source, weight)
        );
    }

    public List<Edge> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

    public int getVertices() {
        return vertices;
    }

    public void displayGraph() {

        System.out.println("\nGraph:");

        for (int i = 0; i < vertices; i++) {

            System.out.print(i + " -> ");

            for (Edge edge : adjacencyList.get(i)) {
                System.out.print(
                    edge.destination + "(" + edge.weight + ") "
                );
            }

            System.out.println();
        }
    }
}
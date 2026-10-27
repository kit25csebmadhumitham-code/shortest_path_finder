import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("      SHORTEST PATH FINDER");
        System.out.println("     Using Dijkstra Algorithm");
        System.out.println("=================================");

        // Create graph with 6 locations
        Graph graph = new Graph(6);

        // Add roads
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 10);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 6);
        graph.addEdge(4, 5, 3);

        // Display graph
        graph.displayGraph();

        System.out.println("\nLocations are numbered from 0 to 5.");

        System.out.print("\nEnter source location: ");
        int source = scanner.nextInt();

        System.out.print("Enter destination location: ");
        int destination = scanner.nextInt();

        // Validate input
        if (source < 0 || source >= graph.getVertices()
                || destination < 0
                || destination >= graph.getVertices()) {

            System.out.println("\nInvalid location!");
            scanner.close();
            return;
        }

        // Find shortest path
        Dijkstra.findShortestPath(
                graph,
                source,
                destination
        );

        scanner.close();
    }
}
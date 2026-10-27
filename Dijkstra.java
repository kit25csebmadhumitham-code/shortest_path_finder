import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

    static class Node implements Comparable<Node> {

        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void findShortestPath(
            Graph graph,
            int source,
            int destination) {

        int vertices = graph.getVertices();

        int[] distance = new int[vertices];
        int[] previous = new int[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);

        distance[source] = 0;

        PriorityQueue<Node> priorityQueue =
                new PriorityQueue<>();

        priorityQueue.add(new Node(source, 0));

        while (!priorityQueue.isEmpty()) {

            Node current = priorityQueue.poll();

            int currentVertex = current.vertex;

            // Ignore old entries
            if (current.distance != distance[currentVertex]) {
                continue;
            }

            for (Edge edge :
                    graph.getNeighbors(currentVertex)) {

                int nextVertex = edge.destination;
                int newDistance =
                        distance[currentVertex] + edge.weight;

                if (newDistance < distance[nextVertex]) {

                    distance[nextVertex] = newDistance;

                    previous[nextVertex] = currentVertex;

                    priorityQueue.add(
                        new Node(nextVertex, newDistance)
                    );
                }
            }
        }

        // No path
        if (distance[destination] == Integer.MAX_VALUE) {

            System.out.println("\nNo path exists.");
            return;
        }

        // Display shortest distance
        System.out.println(
            "\nMinimum Distance: " + distance[destination]
        );

        // Construct path
        int[] path = new int[vertices];

        int count = 0;
        int current = destination;

        while (current != -1) {

            path[count] = current;
            count++;

            current = previous[current];
        }

        System.out.print("Shortest Path: ");

        for (int i = count - 1; i >= 0; i--) {

            System.out.print(path[i]);

            if (i != 0) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
    }
}
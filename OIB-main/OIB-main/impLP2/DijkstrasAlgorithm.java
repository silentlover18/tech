import java.util.*;

class Graph {
    private int V;
    private List<List<Edge>> adj;

    Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<>());
    }

    void addEdge(int u, int v, int weight) {
        adj.get(u).add(new Edge(v, weight));
    }

    void dijkstra(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.dist));
        pq.offer(new Node(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().id;

            for (Edge e : adj.get(u)) {
                int v = e.dest;
                int weight = e.weight;
                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < V; ++i)
            System.out.println("Vertex " + i + ": " + dist[i]);
    }

    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Node {
        int id;
        int dist;

        Node(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }
}

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        Graph graph = new Graph(V);
        System.out.println("Enter the number of edges:");
        int E = scanner.nextInt();
        System.out.println("Enter edges (source, destination, weight):");
        for (int i = 0; i < E; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(source, destination, weight);
        }
        System.out.println("Enter the source vertex:");
        int sourceVertex = scanner.nextInt();
        graph.dijkstra(sourceVertex);
    }
}


/* INPUT

Enter the number of vertices:
5
Enter the number of edges:
7
Enter edges (source, destination, weight):
0 1 4
0 2 1
1 2 2
1 3 5
2 3 2
2 4 3
3 4 4
Enter the source vertex:
0


*/

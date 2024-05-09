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
        adj.get(v).add(new Edge(u, weight));
    }

    void primMST() {
        boolean[] inMST = new boolean[V];
        int[] parent = new int[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.weight));
        key[0] = 0;
        pq.offer(new Edge(0, 0)); // Start from vertex 0

        while (!pq.isEmpty()) {
            int u = pq.poll().dest;
            inMST[u] = true;

            for (Edge e : adj.get(u)) {
                int v = e.dest;
                int weight = e.weight;
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.offer(new Edge(v, key[v]));
                }
            }
        }

        System.out.println("Edges in the MST:");
        for (int i = 1; i < V; ++i)
            System.out.println(parent[i] + " - " + i);
    }

    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}

public class PrimsAlgorithm {
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

        System.out.println("Minimum Spanning Tree using Prim's Algorithm:");
        graph.primMST();
    }
}


/*INPUT
Enter the number of vertices:
5
Enter the number of edges:
7
Enter edges (source, destination, weight):
0 1 2
0 2 3
1 2 1
1 3 4
1 4 5
2 3 7
3 4 6

*/

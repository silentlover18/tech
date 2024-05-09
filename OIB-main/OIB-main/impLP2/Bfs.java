import java.util.*;

class Graph {
    private int V;
    private List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; ++i)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        System.out.println("Breadth-First Traversal starting from vertex " + s + ":");
        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            for (Integer n : adj.get(s)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }
}

public class Bfs {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        Graph graph = new Graph(V);
        System.out.println("Enter the number of edges:");
        int E = scanner.nextInt();
        System.out.println("Enter edges (source followed by destination):");
        for (int i = 0; i < E; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }
        System.out.println("Enter the starting vertex for BFS:");
        int startBFS = scanner.nextInt();
        graph.BFS(startBFS);
    }
}

/*INPUT
Enter the number of vertices:
5
Enter the number of edges:
6
Enter edges (source followed by destination):
0 1
0 2
1 3
1 4
2 3
3 4
Enter the starting vertex for BFS:
0
Breadth-First Traversal starting from vertex 0:
0 1 2 3 4 
*/


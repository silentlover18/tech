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

    public void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (Integer n : adj.get(v)) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    public void DFS(int v) {
        boolean visited[] = new boolean[V];
        System.out.println("Depth-First Traversal starting from vertex " + v + ":");
        DFSUtil(v, visited);
        System.out.println();
    }
}

public class dfs {
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
        System.out.println("Enter the starting vertex for DFS:");
        int startDFS = scanner.nextInt();
        graph.DFS(startDFS);
    }
}


/* INPUT
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
2 4
Enter the starting vertex for DFS:
0
Depth-First Traversal starting from vertex 0:
0 1 3 4 2 

*/

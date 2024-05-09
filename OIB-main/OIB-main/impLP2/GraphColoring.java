import java.util.*;

public class GraphColoring {
    private int V;
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public GraphColoring(int v) {
        V = v;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public boolean isSafe(int v, int[] color, int c) {
        for (int i : adj[v]) {
            if (color[i] == c) {
                return false;
            }
        }
        return true;
    }

    public boolean graphColoringUtil(int[] color, int v, int m) {
        if (v == V) {
            return true;
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(v, color, c)) {
                color[v] = c;
                if (graphColoringUtil(color, v + 1, m)) {
                    return true;
                }
                color[v] = 0;
            }
        }

        return false;
    }

    public boolean graphColoring(int m) {
        int[] color = new int[V];
        Arrays.fill(color, 0);

        if (!graphColoringUtil(color, 0, m)) {
            System.out.println("Solution does not exist");
            return false;
        }

        System.out.println("Solution exists. The coloring of vertices is:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " : Color " + color[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        GraphColoring graph = new GraphColoring(V);
        System.out.println("Enter the number of edges:");
        int E = scanner.nextInt();
        System.out.println("Enter edges (source, destination):");
        for (int i = 0; i < E; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }
        System.out.println("Enter the number of colors available:");
        int m = scanner.nextInt();
        graph.graphColoring(m);
    }
}

/* INPUT

Enter the number of vertices:
5
Enter the number of edges:
6
Enter edges (source, destination):
0 1
0 2
1 2
1 3
2 3
3 4
Enter the number of colors available:
3


*/


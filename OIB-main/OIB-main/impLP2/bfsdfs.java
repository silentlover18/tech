import java.util.*;

class Graph {
    private int V;
    private ArrayList<LinkedList<Integer>> adj;

    Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new LinkedList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj.get(s).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> i = adj.get(v).listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }
}

public class bfsdfs {
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
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Perform BFS");
            System.out.println("2. Perform DFS");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the starting vertex for BFS: ");
                    int startBFS = scanner.nextInt();
                    System.out.print("BFS traversal: ");
                    graph.BFS(startBFS);
                    break;
                case 2:
                    System.out.print("Enter the starting vertex for DFS: ");
                    int startDFS = scanner.nextInt();
                    System.out.print("DFS traversal: ");
                    graph.DFS(startDFS);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
                    break;
            }
        } while (choice != 3);
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
1 2
2 0
2 3
3 3

Menu:
1. Perform BFS
2. Perform DFS
3. Exit
Enter your choice: 1
Enter the starting vertex for BFS: 2
BFS traversal: 2 0 3 1 

Menu:
1. Perform BFS
2. Perform DFS
3. Exit
Enter your choice: 2
Enter the starting vertex for DFS: 2
DFS traversal: 2 0 1 3 

Menu:
1. Perform BFS
2. Perform DFS
3. Exit
Enter your choice: 3
Exiting...



*/


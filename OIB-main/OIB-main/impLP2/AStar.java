import java.util.*;

class Node {
    int id;
    int heuristicCost;
    List<Edge> neighbors;

    public Node(int id, int heuristicCost) {
        this.id = id;
        this.heuristicCost = heuristicCost;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node neighbor, int cost) {
        neighbors.add(new Edge(neighbor, cost));
    }
}

class Edge {
    Node target;
    int cost;

    public Edge(Node target, int cost) {
        this.target = target;
        this.cost = cost;
    }
}

public class AStar {
    public static int astar(Node start, Node goal) {
        Map<Node, Integer> fScore = new HashMap<>();
        Map<Node, Integer> gScore = new HashMap<>();
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(node -> fScore.getOrDefault(node, Integer.MAX_VALUE)));

        gScore.put(start, 0);
        fScore.put(start, start.heuristicCost);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            if (current == goal) {
                return gScore.getOrDefault(current, Integer.MAX_VALUE);
            }

            for (Edge neighborEdge : current.neighbors) {
                Node neighbor = neighborEdge.target;
                int tentativeGScore = gScore.getOrDefault(current, Integer.MAX_VALUE) + neighborEdge.cost;
                if (tentativeGScore < gScore.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    gScore.put(neighbor, tentativeGScore);
                    fScore.put(neighbor, tentativeGScore + neighbor.heuristicCost);
                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the number of nodes
        System.out.println("Enter the number of nodes:");
        int numNodes = scanner.nextInt();
        Node[] nodes = new Node[numNodes];

        // Take input for heuristic cost of each node
        for (int i = 0; i < numNodes; i++) {
            System.out.println("Enter the heuristic cost for node " + i + ":");
            int heuristicCost = scanner.nextInt();
            nodes[i] = new Node(i, heuristicCost);
        }

        // Take input for edges
        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();
        for (int i = 0; i < numEdges; i++) {
            System.out.println("Enter source node, target node, and cost (separated by space) for edge " + i + ":");
            int source = scanner.nextInt();
            int target = scanner.nextInt();
            int cost = scanner.nextInt();
            nodes[source].addNeighbor(nodes[target], cost);
        }

        // Define start and goal nodes
        System.out.println("Enter the ID of the start node:");
        int startId = scanner.nextInt();
        System.out.println("Enter the ID of the goal node:");
        int goalId = scanner.nextInt();

        // Call A* algorithm
        int shortestPathCost = astar(nodes[startId], nodes[goalId]);
        System.out.println("Shortest path cost from node " + startId + " to node " + goalId + ": " + shortestPathCost);
    }
}

/* INPUT

Enter the number of nodes:
4
Enter the heuristic cost for node 0:
10
Enter the heuristic cost for node 1:
5
Enter the heuristic cost for node 2:
7
Enter the heuristic cost for node 3:
3
Enter the number of edges:
4
Enter source node, target node, and cost (separated by space) for edge 0:
0 1 2
Enter source node, target node, and cost (separated by space) for edge 1:
0 2 3
Enter source node, target node, and cost (separated by space) for edge 2:
1 3 4
Enter source node, target node, and cost (separated by space) for edge 3:
2 3 5
Enter the ID of the start node:
0
Enter the ID of the goal node:
3

*/


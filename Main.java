public class Main {
    public static void main(String[] args) {

        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");

        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);

        graph.addEdge(A, B, 2);
        graph.addEdge(B, C, 3);
        graph.addEdge(A, C, 10);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        System.out.println(bfs.bfs(A));

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        System.out.println(dijkstra.shortestPath(A));
    }
}

import java.util.*;
public class BreadthFirstSearch<V> {

    public List<V> bfs(Vertex<V> start) {
        List<V> result = new ArrayList<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            result.add(current.data);

            for (Vertex<V> neighbor : current.getNeighbors().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return result;
    }
}

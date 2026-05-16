import java.util.*;
public class DijkstraSearch<V> {
    public Map<Vertex<V>, Double> shortestPath(Vertex<V> start) {

        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<Vertex<V>> pq =
                new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        for (Vertex<V> v : getAllReachable(start)) {
            distances.put(v, Double.POSITIVE_INFINITY);
        }

        distances.put(start, 0.0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            for (Map.Entry<Vertex<V>, Double> entry : current.getNeighbors().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();

                double newDist = distances.get(current) + weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    pq.add(neighbor);
                }
            }
        }

        return distances;
    }

    private Set<Vertex<V>> getAllReachable(Vertex<V> start) {
        Set<Vertex<V>> visited = new HashSet<>();
        Queue<Vertex<V>> q = new LinkedList<>();

        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            Vertex<V> curr = q.poll();
            for (Vertex<V> n : curr.getNeighbors().keySet()) {
                if (visited.add(n)) {
                    q.add(n);
                }
            }
        }
        return visited;
    }
}


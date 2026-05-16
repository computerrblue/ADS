import java.util.*;
class Vertex<V> {
    V data;
    Map<Vertex<V>, Double> adjacentVertices = new HashMap<>();

    public Vertex(V data) {
        this.data = data;
    }

    public void addNeighbor(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    public Map<Vertex<V>, Double> getNeighbors() {
        return adjacentVertices;
    }
    @Override
    public String toString() {
        return data.toString();
}
}

package in.ashwanik.codility.graph;

import java.util.*;

/**
 * Created by AshwaniK on 7/20/2016.
 */
public class Graph<T> {

    private Map<Long, Vertex<T>> vertices;
    private List<Edge<T>> edges;
    private boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
        vertices = new HashMap<>();
        edges = new ArrayList<>();
    }

    public Collection<Vertex<T>> getVertices() {
        return vertices.values();
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    Vertex<T> start;

    public Vertex<T> getStart() {
        return start;
    }

    public void addEdge(long sourceId, T source, long destinationId, T destination) {
        addEdge(new Vertex<>(sourceId, source), new Vertex<>(destinationId, destination), 0);
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination, int weight) {
        if (vertices.containsKey(source.getId())) {
            source = vertices.get(source.getId());
        } else {
            vertices.put(source.getId(), source);
        }
        if (start == null) {
            start = source;
        }
        if (vertices.containsKey(destination.getId())) {
            destination = vertices.get(destination.getId());
        } else {
            vertices.put(destination.getId(), destination);
        }

        Edge<T> edge = new Edge<>(source, destination, weight, isDirected);
        edges.add(edge);
        source.addAdjacentVertex(edge, destination);
        if (!isDirected) {
            destination.addAdjacentVertex(edge, source);
        }
    }

    public static class Vertex<T> {
        public long getId() {
            return id;
        }

        private long id;
        private T data;
        private List<Vertex<T>> adjacentVertices;
        private List<Edge<T>> edges;

        public Vertex(long id, T data) {
            this.id = id;
            this.data = data;
            adjacentVertices = new ArrayList<>();
            edges = new ArrayList<>();
        }

        public List<Vertex<T>> getAdjacentVertices() {
            return adjacentVertices;
        }

        public List<Edge<T>> getEdges() {
            return edges;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void addAdjacentVertex(Edge<T> edge, Vertex<T> vertex) {
            adjacentVertices.add(vertex);
            edges.add(edge);
        }

        public int getDegree() {
            return edges.size();
        }

        @Override
        public String toString() {
            return id + ":" + data.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex<?> vertex = (Vertex<?>) o;

            if (id != vertex.id) return false;
            return true;

        }

        @Override
        public int hashCode() {
            int result = (int) (id ^ (id >>> 32));
            result = 31 * result + data.hashCode();
            return result;
        }
    }

    public static class Edge<T> {
        private Vertex<T> source;
        private Vertex<T> destination;
        private boolean isDirected;
        private int weight;

        public Edge(Vertex<T> source, Vertex<T> destination) {
            this(source, destination, 0);
        }

        public Edge(Vertex<T> source, Vertex<T> destination, int weight) {
            this(source, destination, weight, false);
        }

        public Edge(Vertex<T> source, Vertex<T> destination, boolean isDirected) {
            this(source, destination, 0, isDirected);
        }

        public Edge(Vertex<T> source, Vertex<T> destination, int weight, boolean isDirected) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
            this.isDirected = isDirected;
        }

        public boolean isDirected() {
            return isDirected;
        }

        public int getWeight() {
            return weight;
        }

        public Vertex<T> getDestination() {
            return destination;
        }

        public Vertex<T> getSource() {
            return source;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "source=" + source +
                    ", destination=" + destination +
                    ", isDirected=" + isDirected +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge<?> edge = (Edge<?>) o;

            if (isDirected != edge.isDirected) return false;
            if (weight != edge.weight) return false;
            if (source != null ? !source.equals(edge.source) : edge.source != null) return false;
            return !(destination != null ? !destination.equals(edge.destination) : edge.destination != null);

        }

        @Override
        public int hashCode() {
            int result = source != null ? source.hashCode() : 0;
            result = 31 * result + (destination != null ? destination.hashCode() : 0);
            result = 31 * result + (isDirected ? 1 : 0);
            result = 31 * result + weight;
            return result;
        }
    }
}

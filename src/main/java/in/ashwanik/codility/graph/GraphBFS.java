package in.ashwanik.codility.graph;

import in.ashwanik.codility.builders.GraphBuilder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by AshwaniK on 7/20/2016.
 */
public class GraphBFS {
    public static void main(String[] args) {
        Graph<Integer> graph = GraphBuilder.createGraph(false);
        bfs(graph);
    }

    private static void bfs(Graph<Integer> graph) {
        Set<Graph.Vertex<Integer>> visited = new HashSet<>();
        Deque<Graph.Vertex<Integer>> queue = new ArrayDeque<>();
        queue.add(graph.getStart());
        visited.add(graph.getStart());
        while (!queue.isEmpty()) {
            Graph.Vertex<Integer> current = queue.remove();
            for (Graph.Vertex<Integer> vertex : current.getAdjacentVertices()) {
                if (!visited.contains(vertex)) {
                    visited.add(vertex);
                    queue.add(vertex);
                }
            }
            System.out.println(current);
        }
    }
}

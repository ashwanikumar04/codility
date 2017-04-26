package in.ashwanik.codility.graph;

import in.ashwanik.codility.builders.GraphBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by AshwaniK on 7/20/2016.
 */
public class GraphDFS {
    public static void main(String[] args) {
        Graph<Integer> graph = GraphBuilder.createGraph(true);
        dfs(graph);
    }

    private static void dfs(Graph<Integer> graph) {
        Set<Graph.Vertex<Integer>> visited = new HashSet<>();
        dfsUtil(graph.getStart(), visited);
    }

    private static void dfsUtil(Graph.Vertex<Integer> vertex, Set<Graph.Vertex<Integer>> visited) {
        visited.add(vertex);
        System.out.println(vertex);
        for (Graph.Vertex<Integer> adjacentVertex : vertex.getAdjacentVertices()) {
            if (!visited.contains(adjacentVertex)) {
                dfsUtil(adjacentVertex, visited);
            }
        }
    }
}

package in.ashwanik.codility.builders;

import in.ashwanik.codility.graph.Graph;

/**
 * Created by AshwaniK on 7/10/2016.
 */
public class GraphBuilder {

    public static Graph<Integer> createGraph(boolean isDirected) {
        Graph<Integer> graph = new Graph<>(isDirected);
        graph.addEdge(0, 0, 1, 1);
        graph.addEdge(0, 0, 2, 2);
        graph.addEdge(0, 0, 3, 3);
        graph.addEdge(2, 2, 3, 3);
        graph.addEdge(1, 1, 3, 3);
        return graph;
    }
}

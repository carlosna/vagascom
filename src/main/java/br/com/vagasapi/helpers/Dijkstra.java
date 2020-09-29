package br.com.vagasapi.helpers;

import br.com.vagasapi.domain.Graph;
import br.com.vagasapi.domain.Node;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

@Component
public class Dijkstra {
//
//    // Create a simple weighted directed graph with Hipster where
//    // vertices are Strings and edge values are just doubles
//
//    HipsterDirectedGraph<String,Double> graph = GraphBuilder.create()
//            .connect("A").to("B").withEdge(5d)
//            .connect("B").to("A").withEdge(5d)
//            .connect("B").to("C").withEdge(7d)
//            .connect("B").to("D").withEdge(3d)
//            .connect("C").to("E").withEdge(4d)
//            .connect("D").to("F").withEdge(8d)
//            .connect("E").to("D").withEdge(10d)
//            .buildDirectedGraph();
//
//    //  Search the shortest path from "A" to "F"
//    public Integer getDistance(String pessoa, String vaga){
//        // Create the search problem. For graph problems, just use
//        // the GraphSearchProblem util class to generate the problem with ease.
//        SearchProblem p = GraphSearchProblem
//                .startingFrom(pessoa)
//                .in(graph)
//                .takeCostsFromEdges()
//                .build();
//
//        Integer distance =  Integer.valueOf(Hipster.createDijkstra(p).search(vaga).
//                            getGoalNode().
//                            toString().
//                            substring(54).
//                            replace(".0}",""));
//        return distance;
//    }
//
    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);

            for (Map.Entry<Node,Integer> adjacencyPair: currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

}

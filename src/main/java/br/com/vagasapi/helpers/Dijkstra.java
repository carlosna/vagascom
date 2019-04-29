package br.com.vagasapi.helpers;

import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.graph.GraphBuilder;
import es.usc.citius.hipster.graph.GraphSearchProblem;
import es.usc.citius.hipster.graph.HipsterDirectedGraph;
import es.usc.citius.hipster.model.problem.SearchProblem;
import org.springframework.stereotype.Component;

@Component
public class Dijkstra {

    // Create a simple weighted directed graph with Hipster where
    // vertices are Strings and edge values are just doubles

    HipsterDirectedGraph<String,Double> graph = GraphBuilder.create()
            .connect("A").to("B").withEdge(5d)
            .connect("B").to("A").withEdge(5d)
            .connect("B").to("C").withEdge(7d)
            .connect("B").to("D").withEdge(3d)
            .connect("C").to("E").withEdge(4d)
            .connect("D").to("F").withEdge(8d)
            .connect("E").to("D").withEdge(10d)
            .buildDirectedGraph();

    //  Search the shortest path from "A" to "F"
    public Integer getDistance(String pessoa, String vaga){
        // Create the search problem. For graph problems, just use
        // the GraphSearchProblem util class to generate the problem with ease.
        SearchProblem p = GraphSearchProblem
                .startingFrom(pessoa)
                .in(graph)
                .takeCostsFromEdges()
                .build();

        Integer distance =  Integer.valueOf(Hipster.createDijkstra(p).search(vaga).
                            getGoalNode().
                            toString().
                            substring(54).
                            replace(".0}",""));
        return distance;
    }

}

package br.com.vagasapi.test;

import br.com.vagasapi.domain.Graph;
import br.com.vagasapi.domain.Node;
import br.com.vagasapi.helpers.Dijkstra;
import br.com.vagasapi.test.domain.Edge;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShortestPathTest {

    static List<Edge> edges = Arrays.asList(
          new Edge(new Node("A"),new Node("B"),10),
          new Edge(new Node("B"),new Node("C"),7),
          new Edge(new Node("B"),new Node("D"), 3),
          new Edge(new Node("C"),new Node("E"), 4)
    );

    @Test
    public void deveRetornarADistanciaEntreNodeAeD(){
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 5);

        nodeB.addDestination(nodeA, 5);
        nodeB.addDestination(nodeC, 7);
        nodeB.addDestination(nodeD, 3);

        nodeC.addDestination(nodeB, 7);
        nodeC.addDestination(nodeE, 4);

        nodeD.addDestination(nodeB, 3);
        nodeD.addDestination(nodeE, 10);
        nodeD.addDestination(nodeF, 8);

        nodeE.addDestination(nodeC, 4);
        nodeE.addDestination(nodeD, 10);

        nodeF.addDestination(nodeD, 8);
//
//        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
//        graph.addNode(nodeB);
//        graph.addNode(nodeC);
//        graph.addNode(nodeD);
//        graph.addNode(nodeE);
//        graph.addNode(nodeF);

        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeE);
        Integer distancia = graph.getNodes().
                            stream().
                            mapToInt(n -> n.getDistance()).
                            findFirst().
                            getAsInt();

        //System.out.println(distance.getAsInt());
/*

        CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();
        Node source = new Node("A");
        Node dest =  new Node("D");

        Integer distancia = calculadorDeDistancia.calculaDistancia(edges, source, dest);
*/


        assertEquals(16 , distancia, 0);
    }

//    @Test
//    public void deveRetornarADistanciaEntreNodeBeD(){
//
//        CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();
//        Node source = new Node("B");
//        Node dest = new Node("D");
//
//        Integer distancia = calculadorDeDistancia.calculaDistancia(edges, source, dest);
//
//        assertEquals(10 , distancia, 0);
//    }
//
//    @Test
//    public void deveRetornarADistanciaEntreNodeAeE(){
//
//        CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();
//        Node source = new Node("A");
//        Node dest =  new Node("E");
//
//        Integer distancia = calculadorDeDistancia.calculaDistancia(edges, source, dest);
//
//        assertEquals(24 , distancia, 0);
//    }
}

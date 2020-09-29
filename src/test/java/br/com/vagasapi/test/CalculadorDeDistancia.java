package br.com.vagasapi.test;

import br.com.vagasapi.domain.Node;
import br.com.vagasapi.test.domain.Edge;

import java.util.List;

public class CalculadorDeDistancia {

    public Integer calculaDistancia(List<Edge> edges, Node source, Node dest){
        int sum = 0;
        int i = 0;

//        for (i = devolveIndice(edges, source, i); edges.get(i).getDest().getNode() != dest.getNode() ; i++ ) {
//            sum += edges.get(i).getDistance();
//        }
        sum += edges.get(i).getDistance();

        return sum;
    }

    private int devolveIndice(List<Edge> edges, Node source, int i) {
        for (Edge edge: edges){
//            if(edge.getSource().getNode() == source.getNode()) {
//                return edges.indexOf(edge);
//            }
        }

        return i;
    }



//    public List<Edge> menorDistancia(List<Edge> edges){
//        edges.stream().
//        return null;
//    }
}

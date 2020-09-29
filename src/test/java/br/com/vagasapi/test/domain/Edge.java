package br.com.vagasapi.test.domain;

import br.com.vagasapi.domain.Node;

import java.util.Objects;

public class Edge {

    private Node source;
    private Node dest;
    private int distance;

    public Edge(Node source, Node dest, int distance) {
        this.source = source;
        this.dest = dest;
        this.distance = distance;
    }

    public Node getSource() {
        return source;
    }

    public Node getDest() {
        return dest;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return source.equals(edge.source) &&
                dest.equals(edge.dest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, dest);
    }
}

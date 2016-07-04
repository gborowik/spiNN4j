package com.spiNN4j.algorithm.graph.model;

/**
 * Created by Grzegorz Borowik on 2016-07-04 3:15 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Edge {

    private Vertex first;
    private Vertex second;

    public Edge(Vertex first, Vertex second) {
        this.first = first;
        this.second = second;
    }

}

package com.spiNN4j.algorithm.graph.model;

import com.spiNN4j.algorithm.graph.algorithm.AllPairs;
import com.spiNN4j.algorithm.graph.algorithm.ConnectionGenerator.Factory;

/**
 * Created by Grzegorz Borowik on 2016-07-04 3:15 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Edge<T> extends AllPairs.Pair<T> {

    public Edge(T first, T second) {
        super(first, second);
    }

    public static final Factory<Edge, Vertex> factory = pair -> new Edge<>(pair.first, pair.second);
}

package com.spiNN4j.algorithm.graph.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Grzegorz Borowik on 2016-07-04 1:49 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class DirectedGraph {

    protected Set<Vertex> neurons = new HashSet<>();
    protected Set<Edge> synapses = new HashSet<>();

}

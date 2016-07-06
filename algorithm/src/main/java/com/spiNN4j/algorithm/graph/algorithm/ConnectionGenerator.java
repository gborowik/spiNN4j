package com.spiNN4j.algorithm.graph.algorithm;

import com.spiNN4j.algorithm.graph.algorithm.AllPairs.Pair;
import com.spiNN4j.algorithm.graph.model.Edge;
import com.spiNN4j.algorithm.graph.model.Vertex;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.spiNN4j.algorithm.graph.algorithm.AllPairs.allPairs;
import static java.lang.Math.pow;
import static net.seninp.jmotif.sax.algorithm.StdRandom.bernoulli;

/**
 * Created by Grzegorz Borowik on 2016-07-04 1:50 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class ConnectionGenerator {

    public List<Edge> generateConnectionsInSphereAndWithProbability(
            List<Vertex> vertices, Double radius, Double probability) {

        return StreamSupport.stream(allPairs(vertices).spliterator(), false)
                .filter(pair -> pairIsInTheRadius(pair, radius))
                .filter(pair -> bernoulli(probability))
                .map(pair -> new Edge(pair.first, pair.second))
                .collect(Collectors.toList());
    }

    private boolean pairIsInTheRadius(Pair<Vertex> pair, Double radius) {

        return (pow(pair.first.position().x() - pair.second.position().x(), 2.0d)
                + pow(pair.first.position().y() - pair.second.position().y(), 2.0d)
                + pow(pair.first.position().z() - pair.second.position().z(), 2.0d))
                < (pow(radius, 2.0d));
    }

}

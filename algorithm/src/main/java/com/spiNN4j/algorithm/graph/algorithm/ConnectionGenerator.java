package com.spiNN4j.algorithm.graph.algorithm;

import com.spiNN4j.algorithm.graph.model.Edge;
import com.spiNN4j.algorithm.graph.model.Vertex;
import com.spiNN4j.model.data.Pair;

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
public class ConnectionGenerator<E extends Edge, V extends Vertex> {

    private final Factory<E, V> factory;

    public ConnectionGenerator(Factory<E, V> factory) {
        this.factory = factory;
    }

    public List<E> generateConnectionsInSphereAndWithProbability(
            List<V> vertices, Double radius, Double probability) {

        return StreamSupport.stream(allPairs(vertices).spliterator(), false)
                .filter(pair -> pairIsInTheRadius(pair, radius))
                .filter(pair -> bernoulli(probability))
                .map(factory::create)
                .collect(Collectors.toList());
    }

    private boolean pairIsInTheRadius(Pair<? extends Vertex> pair, Double radius) {

        return (pow(pair.first.position().x() - pair.second.position().x(), 2.0d) +
                pow(pair.first.position().y() - pair.second.position().y(), 2.0d) +
                pow(pair.first.position().z() - pair.second.position().z(), 2.0d))
                < (pow(radius, 2.0d));
    }

    public interface Factory<E, V> {
        E create(Pair<V> pair);
    }

}

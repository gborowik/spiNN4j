package com.spiNN4j.algorithm.graph.algorithm;

import com.spiNN4j.algorithm.graph.model.Vertex;
import com.spiNN4j.model.data.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Grzegorz Borowik on 2016-07-04 3:17 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class VertexGenerator {

    List<Vertex> cube(int numberOfVerticesForSide, Double distanceBetween2VerticesOnSide) {
        List<Vertex> vertices = new ArrayList<>();


        IntStream.rangeClosed(1, numberOfVerticesForSide)
                .forEach(x -> IntStream.rangeClosed(1, numberOfVerticesForSide)
                        .forEach(y -> IntStream.rangeClosed(1, numberOfVerticesForSide)
                                .forEach(z -> vertices.add(new Vertex(new Position(
                                                x * distanceBetween2VerticesOnSide,
                                                y * distanceBetween2VerticesOnSide,
                                                z * distanceBetween2VerticesOnSide
                                        )))
                                )
                        )
                );

        return vertices;
    }

}

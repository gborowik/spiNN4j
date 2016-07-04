package com.spiNN4j.algorithm.graph.algorithm

import com.spiNN4j.algorithm.graph.model.Vertex
import com.spiNN4j.model.data.Position
import spock.lang.Specification

import java.util.stream.Collectors

/**
 * Created by Grzegorz Borowik on 2016-07-04 3:56 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class VertexGeneratorTest extends Specification {

    VertexGenerator vertexGenerator = new VertexGenerator()

    def "Should generateCubeOfVertices"() {
        when:
        List<Vertex> vertices = vertexGenerator.cube(nbOfElementsOnSide, distance)

        List<Position> positions = vertices.stream().map { el -> el.position() }.collect(Collectors.toList());

        List<List<Double>> listOfPositions = new ArrayList<>();

        positions.stream().forEach { el -> listOfPositions.add(new ArrayList<Double>(Arrays.asList(el.x(), el.y(), el.z()))) }

        then:
        listOfPositions.containsAll(expected)

        where:
        nbOfElementsOnSide | distance | expected
        1                  | 1d       | [[1d, 1d, 1d]]
        3                  | 1d       | [[1d, 1d, 1d], [1d, 1d, 2d], [1d, 2d, 1d], [2d, 1d, 1d], [1d, 2d, 2d], [2d, 2d, 1d], [2d, 1d, 2d], [2d, 2d, 2d]]
    }

}
package com.spiNN4j.algorithm.graph.model;

import com.spiNN4j.model.data.Position;

/**
 * Created by Grzegorz Borowik on 2016-07-04 3:13 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Vertex {

    private Position position;

    public Vertex(Position position) {
        this.position = position;
    }

    public Position position() {
        return this.position;
    }

}

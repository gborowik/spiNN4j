package com.spiNN4j.model.data;

/**
 * Created by Grzegorz Borowik on 2016-06-22 4:08 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Position extends Triple<Double> {

    public Position(Double x, Double y, Double z) {
        first = x;
        second = y;
        third = z;
    }

    public double x() {
        return first;
    }

    public double y() {
        return second;
    }

    public double z() {
        return third;
    }
}

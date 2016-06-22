package com.spiNN4j.algorithm.threshold.model;

import com.spiNN4j.model.data.DataVector;

/**
 * Created by Grzegorz Borowik on 2016-06-19 2:14 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class ThresholdVector {
    private DataVector<Double> vector;

    public ThresholdVector(DataVector<Double> vector) {
        this.vector = vector;
    }
}

package com.spiNN4j.algorithm.AER.model;

import com.spiNN4j.model.data.DataMatrix;

import java.util.stream.Stream;

/**
 * Created by Grzegorz Borowik on 2016-06-19 2:10 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class StreamOfSamples {

    private Stream<DataMatrix<Double>> samples;

    public StreamOfSamples(Stream<DataMatrix<Double>> samples) {
        this.samples = samples;
    }
}

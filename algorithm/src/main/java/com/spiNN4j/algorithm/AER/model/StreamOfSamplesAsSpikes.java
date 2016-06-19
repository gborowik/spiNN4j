package com.spiNN4j.algorithm.AER.model;

import com.spiNN4j.model.data.DataMatrix;

import java.util.stream.Stream;

/**
 * Created by Grzegorz Borowik on 2016-06-19 6:19 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class StreamOfSamplesAsSpikes {
    private Stream<DataMatrix<Boolean>> samples;

    public StreamOfSamplesAsSpikes(Stream<DataMatrix<Boolean>> samples) {
        this.samples = samples;
    }

    public Stream<DataMatrix<Boolean>> getStream() {
        return samples;
    }
}

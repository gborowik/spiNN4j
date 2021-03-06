package com.spiNN4j.algorithm.AER;

import com.spiNN4j.algorithm.AER.model.StreamOfSamplesAsSpikes;
import com.spiNN4j.io.model.StreamOfSamplesAsDouble;
import com.spiNN4j.model.algorithm.Algorithm;
import com.spiNN4j.runner.Configurator;

/**
 * Created by Grzegorz Borowik on 2016-06-19 6:16 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class AERAlgorithm implements Algorithm {
    StreamOfSamplesAsDouble input;
    StreamOfSamplesAsSpikes output;
    Configurator configurator;

    public AERAlgorithm(StreamOfSamplesAsDouble input, StreamOfSamplesAsSpikes output, Configurator configurator) {
        this.input = input;
        this.output = output;
        this.configurator = configurator;
    }

    @Override
    public void run() {

    }
}

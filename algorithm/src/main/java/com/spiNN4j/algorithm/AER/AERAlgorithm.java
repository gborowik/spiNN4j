package com.spiNN4j.algorithm.AER;

import com.spiNN4j.algorithm.AER.model.StreamOfSamples;
import com.spiNN4j.algorithm.AER.model.StreamOfSamplesAsSpikes;
import com.spiNN4j.model.algorithm.Algorithm;
import com.spiNN4j.runner.Configurator;

/**
 * Created by Grzegorz Borowik on 2016-06-17 2:51 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class AERAlgorithm implements Algorithm {
    StreamOfSamples input;
    StreamOfSamplesAsSpikes output;
    Configurator configurator;

    public AERAlgorithm(StreamOfSamples input, StreamOfSamplesAsSpikes output, Configurator configurator) {
        this.input = input;
        this.output = output;
        this.configurator = configurator;
    }

    @Override
    public void run() {


    }
}

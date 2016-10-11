package com.spiNN4j.algorithm.threshold;

import com.spiNN4j.algorithm.threshold.model.ThresholdVector;
import com.spiNN4j.model.algorithm.Algorithm;
import com.spiNN4j.io.model.StreamOfSamplesAsDouble;
import com.spiNN4j.runner.Configurator;

/**
 * Created by Grzegorz Borowik on 2016-06-17 2:51 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class ThresholdAlgorithm implements Algorithm {
    StreamOfSamplesAsDouble input;
    ThresholdVector output;
    Configurator configurator;

    public ThresholdAlgorithm(StreamOfSamplesAsDouble input, ThresholdVector output, Configurator configurator) {
        this.input = input;
        this.output = output;
        this.configurator = configurator;
    }

    @Override
    public void run() {

    }
}

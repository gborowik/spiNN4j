package com.spiNN4j.algorithm.Threshold;

import com.spiNN4j.algorithm.Threshold.model.ThresholdVector;
import com.spiNN4j.model.algorithm.Algorithm;
import com.spiNN4j.model.data.StreamOfSamples;
import com.spiNN4j.runner.Configurator;

/**
 * Created by Grzegorz Borowik on 2016-06-17 2:51 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class ThresholdAlgorithm implements Algorithm {
    StreamOfSamples input;
    ThresholdVector output;
    Configurator configurator;

    public ThresholdAlgorithm(StreamOfSamples input, ThresholdVector output, Configurator configurator) {
        this.input = input;
        this.output = output;
        this.configurator = configurator;
    }

    @Override
    public void run() {

    }
}

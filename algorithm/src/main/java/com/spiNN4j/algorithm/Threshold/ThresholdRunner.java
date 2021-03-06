package com.spiNN4j.algorithm.threshold;

import com.spiNN4j.algorithm.threshold.model.ThresholdVector;
import com.spiNN4j.model.algorithm.Algorithm;
import com.spiNN4j.model.algorithm.AlgorithmRunner;
import com.spiNN4j.io.model.StreamOfSamplesAsDouble;
import com.spiNN4j.runner.Configurator;

/**
 * Created by Grzegorz Borowik on 2016-06-17 2:51 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class ThresholdRunner implements AlgorithmRunner<StreamOfSamplesAsDouble, ThresholdVector, Configurator> {

    @Override
    public Class<StreamOfSamplesAsDouble> getInputType() {
        return StreamOfSamplesAsDouble.class;
    }

    @Override
    public Class<ThresholdVector> getOutputType() {
        return ThresholdVector.class;
    }

    @Override
    public Class<Configurator> getConfigurator() {
        return Configurator.class;
    }

    @Override
    public Algorithm newInstance(StreamOfSamplesAsDouble input, ThresholdVector output, Configurator configurator) {
        return new ThresholdAlgorithm(input, output, configurator);
    }
}

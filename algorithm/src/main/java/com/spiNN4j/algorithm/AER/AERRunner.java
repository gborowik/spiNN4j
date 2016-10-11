package com.spiNN4j.algorithm.AER;

import com.spiNN4j.io.model.StreamOfSamplesAsDouble;
import com.spiNN4j.algorithm.AER.model.StreamOfSamplesAsSpikes;
import com.spiNN4j.model.algorithm.Algorithm;
import com.spiNN4j.model.algorithm.AlgorithmRunner;
import com.spiNN4j.runner.Configurator;

/**
 * Created by Grzegorz Borowik on 2016-06-19 6:16 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class AERRunner implements AlgorithmRunner<StreamOfSamplesAsDouble, StreamOfSamplesAsSpikes, Configurator> {

    @Override
    public Class<StreamOfSamplesAsDouble> getInputType() {
        return StreamOfSamplesAsDouble.class;
    }

    @Override
    public Class<StreamOfSamplesAsSpikes> getOutputType() {
        return StreamOfSamplesAsSpikes.class;
    }

    @Override
    public Class<Configurator> getConfigurator() {
        return Configurator.class;
    }

    @Override
    public Algorithm newInstance(StreamOfSamplesAsDouble input, StreamOfSamplesAsSpikes output, Configurator configurator) {
        return new AERAlgorithm(input, output, configurator);
    }
}

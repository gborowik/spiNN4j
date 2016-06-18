package com.spiNN4j.algorithm.AER;

import com.spiNN4j.algorithm.AER.model.StreamOfSamples;
import com.spiNN4j.algorithm.AER.model.StreamOfSamplesAsSpikes;
import com.spiNN4j.model.algorithm.Algorithm;
import com.spiNN4j.model.algorithm.AlgorithmRunner;
import com.spiNN4j.runner.Configurator;

/**
 * Created by Grzegorz Borowik on 2016-06-17 2:51 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class AERRunner implements AlgorithmRunner<StreamOfSamples, StreamOfSamplesAsSpikes, Configurator> {

    @Override
    public Class<StreamOfSamples> getInputType() {
        return StreamOfSamples.class;
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
    public Algorithm newInstance(StreamOfSamples input, StreamOfSamplesAsSpikes output, Configurator configurator) {
        return new AERAlgorithm(input, output, configurator);
    }
}

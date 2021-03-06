package com.spiNN4j.model.algorithm;

/**
 * Created by Grzegorz Borowik on 2016-06-19 1:02 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public interface AlgorithmRunner<In, Ou, Conf> {

    public Class<In> getInputType();

    public Class<Ou> getOutputType();

    public Class<Conf> getConfigurator();

    public Algorithm newInstance(In in, Ou ou, Conf conf);
}

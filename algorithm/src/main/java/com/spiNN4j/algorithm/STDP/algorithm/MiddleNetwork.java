package com.spiNN4j.algorithm.STDP.algorithm;

import com.spiNN4j.algorithm.STDP.model.Network;

/**
 * Created by Grzegorz Borowik on 2016-06-24 12:13 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class MiddleNetwork extends Network {

    @Override
    public void tick() {

        neurons.parallelStream().forEach(neuron -> neuron.checkMembranePotentialForAction());

        neurons.parallelStream().forEach(neuron -> neuron.propagateSpikesToDendrites());

    }
}

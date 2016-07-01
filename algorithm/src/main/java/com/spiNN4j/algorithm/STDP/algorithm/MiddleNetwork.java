package com.spiNN4j.algorithm.STDP.algorithm;

import com.spiNN4j.algorithm.STDP.model.Network;

/**
 * Created by Grzegorz Borowik on 2016-06-24 12:13 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class MiddleNetwork extends Network {

    private Double time = 0.0d;

    @Override
    public void tick() {

        time++;

        neurons.parallelStream()
                .filter(neuron -> neuron.updatePotentialAndCheckIfFired(time))
                .forEach(neuron -> {
                    neuron.updateWeightForIncomingSynapses();
                    neuron.updateWeightForOutgoingSynapses();
                    neuron.propagateSpikesToOutgoingSynapses();
                });

    }

}

package com.spiNN4j.algorithm.STDP.model;

import com.spiNN4j.algorithm.STDP.algorithm.Neuron;
import com.spiNN4j.algorithm.STDP.algorithm.Synapse;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Grzegorz Borowik on 2016-06-24 12:19 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public abstract class Network implements INetwork {

    protected Set<Neuron> neurons = new HashSet<>();
    protected Set<Synapse> synapses = new HashSet<>();

    public Network addNeuron(Neuron neuron) {
        neurons.add(neuron);
        return this;
    }

    public Network addSynapse(Synapse synapse) {
        synapses.add(synapse);
        return this;
    }

}

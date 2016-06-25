package com.spiNN4j.algorithm.STDP.algorithm;

/**
 * Created by Grzegorz Borowik on 2016-06-26 12:03 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Synapse {

    private Double weight;

    private Neuron preSynapticNeuron;
    private Neuron postSynapticNeuron;

    public Synapse(Neuron preSynapticNeuron, Neuron postSynapticNeuron, Double weight) {
        this.preSynapticNeuron = preSynapticNeuron;
        this.postSynapticNeuron = postSynapticNeuron;
        this.weight = weight;
    }

    public Synapse(Neuron preSynapticNeuron, Neuron postSynapticNeuron) {
        this.preSynapticNeuron = preSynapticNeuron;
        this.postSynapticNeuron = postSynapticNeuron;
        this.weight = 0d;
    }

    public void propagateSpike(Double spikeValue) {
        postSynapticNeuron.receiveSpike(spikeValue);
    }

    public void updateWeight() {

    }
}

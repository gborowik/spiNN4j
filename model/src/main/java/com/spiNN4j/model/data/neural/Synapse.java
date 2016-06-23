package com.spiNN4j.model.data.neural;

/**
 * Created by Grzegorz Borowik on 2016-06-23 4:51 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Synapse {

    private Neuron fromNeuron;
    private Neuron toNeuron;

    private Double weight = 0d;

    public Synapse(Neuron fromNeuron, Neuron toNeuron, Double weight) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;
        this.weight = weight;
    }


}

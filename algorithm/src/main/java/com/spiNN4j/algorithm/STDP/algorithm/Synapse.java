package com.spiNN4j.algorithm.STDP.algorithm;

import static com.spiNN4j.algorithm.STDP.configurator.SynapseConfigurator.*;
import static java.lang.Math.exp;

/**
 * Created by Grzegorz Borowik on 2016-06-26 12:03 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Synapse {

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

    private Double weight;
    private Double tauPositive = TAU_POSITIVE_DEFAULT;
    private Double tauNegative = TAU_NEGATIVE_DEFAULT;
    private Double weightPositive = WEIGHT_POSITIVE_DEFAULT;
    private Double weightNegative = WEIGHT_NEGATIVE_DEFAULT;
    private Double learningRate = LEARNING_RATE_DEFAULT;

    public void updateWeight() {
        if (preSynapticNeuron.spiked() || postSynapticNeuron.spiked()) {
            sumUpWithSynapseWeight(
                    calculateWeightUpdate(preSynapticNeuron.getSpikeTime() - postSynapticNeuron.getSpikeTime())
            );
        }
    }

    private void sumUpWithSynapseWeight(Double weightDiff) {
        if (weight < 0.0d) {
            weight -= weightDiff;
        } else {
            weight += weightDiff;
        }
    }

    private Double calculateWeightUpdate(Double timeDiff) {
        if (timeDiff < 0.0d) {
            return (weightPositive * learningRate * exp(timeDiff / tauPositive));
        } else {
            return (-weightNegative * learningRate * exp(-timeDiff / tauNegative));
        }
    }

}

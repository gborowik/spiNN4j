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

    public void propagateSpike() {
        postSynapticNeuron.receiveSpike(weight);
    }

    private Double weight;
    private Double tauPositive = TAU_POSITIVE_DEFAULT;
    private Double tauNegative = TAU_NEGATIVE_DEFAULT;
    private Double weightPositive = WEIGHT_POSITIVE_DEFAULT;
    private Double weightNegative = WEIGHT_NEGATIVE_DEFAULT;

    public void updateWeight() {
        sumUpWithSynapseWeight(
                calculateWeightUpdate(
                        preSynapticNeuron.getSpikeTime() - postSynapticNeuron.getSpikeTime()
                )
        );
    }

    private void sumUpWithSynapseWeight(Double weightUpdate) {
        if (weight < 0.0d) {
            weight -= weightUpdate;
        } else {
            weight += weightUpdate;
        }
    }

    private Double calculateWeightUpdate(Double timeDifference) {
        if (timeDifference < 0.0d) {
            return (weightPositive * exp(timeDifference / tauPositive));
        } else {
            return (-weightNegative * exp(-timeDifference / tauNegative));
        }
    }

}

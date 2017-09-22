package com.spiNN4j.algorithm.STDP.algorithm;

import com.spiNN4j.algorithm.graph.model.Edge;

import static com.spiNN4j.algorithm.STDP.configurator.SynapseConfigurator.*;
import static java.lang.Math.exp;

/**
 * Created by Grzegorz Borowik on 2016-06-26 12:03 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Synapse extends Edge {

    private Neuron preSynapticNeuron;
    private Neuron postSynapticNeuron;

    public Synapse(Neuron preSynapticNeuron, Neuron postSynapticNeuron, Double weight) {
        super(preSynapticNeuron, postSynapticNeuron);
        this.preSynapticNeuron = preSynapticNeuron;
        this.postSynapticNeuron = postSynapticNeuron;
        this.weight = weight;
    }

    public Synapse(Neuron preSynapticNeuron, Neuron postSynapticNeuron) {
        super(preSynapticNeuron, postSynapticNeuron);
        this.preSynapticNeuron = preSynapticNeuron;
        this.postSynapticNeuron = postSynapticNeuron;
        this.weight = 0d;
    }

    public void propagateSpike() {
        postSynapticNeuron.receiveSpike(weight);
    }

    private Double weight = 0.1d;
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
        weight += weightUpdate;
    }

    private Double calculateWeightUpdate(Double timeDifference) {
        if (timeDifference < 0.0d) {
            return (weightPositive * exp(timeDifference / tauPositive));
        } else if (timeDifference > 0.0d) {
            return (-weightNegative * exp(-timeDifference / tauNegative));
        } else {
            return 0.0d;
        }
    }

}

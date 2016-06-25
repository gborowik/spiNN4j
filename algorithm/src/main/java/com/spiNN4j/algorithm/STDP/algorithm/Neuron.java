package com.spiNN4j.algorithm.STDP.algorithm;

import java.util.HashSet;
import java.util.Set;

import static com.spiNN4j.runner.Constants.SPIKE;

/**
 * Created by Grzegorz Borowik on 2016-06-23 6:16 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Neuron {

    private Double membranePotential;
    private Double maxMembranePotential;

    protected Set<Synapse> incomingDendrites = new HashSet<>();
    protected Set<Synapse> outgoingDendrites = new HashSet<>();

    public Neuron addDendriteToNeuron(Synapse synapse) {
        this.incomingDendrites.add(synapse);
        return this;
    }

    public Neuron addDendriteFromNeuron(Synapse synapse) {
        this.outgoingDendrites.add(synapse);
        return this;
    }

    public Neuron(Double maxMembranePotential) {
        this.maxMembranePotential = maxMembranePotential;
    }

    public void resetMembranePotential() {
        membranePotential = 0.0d;
    }

    public void receiveSpike(Double spikeValue) {
        membranePotential += spikeValue;
    }

    public void checkMembranePotentialForAction() {
        if (membranePotential >= maxMembranePotential) {
            propagateSpikesToDendrites();
            resetMembranePotential();
        }
    }

    private void propagateSpikesToDendrites() {
        outgoingDendrites.stream().forEach(synapse -> synapse.propagateSpike(SPIKE));
    }
}

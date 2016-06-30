package com.spiNN4j.algorithm.STDP.algorithm;

import java.util.HashSet;
import java.util.Set;

import static com.spiNN4j.model.types.ActionPotential.NO_POTENTIAL;
import static com.spiNN4j.model.types.ActionPotential.SPIKE;

/**
 * Created by Grzegorz Borowik on 2016-06-23 6:16 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Neuron {

    private Double membranePotential;
    private Double maxMembranePotential;
    private Double actionPotential;
    private boolean spiked;
    private Double spikeTime;

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
        membranePotential = NO_POTENTIAL;
    }

    public void resetActionPotential() {
        actionPotential = NO_POTENTIAL;
    }

    public void receiveSpike(Double spikeValue) {
        membranePotential += spikeValue;
    }

    public void checkMembranePotentialForAction(Double time) {
        if (membranePotential >= maxMembranePotential) {
            actionPotential = membranePotential;
            resetMembranePotential();
        }
    }

    public void propagateSpikesToDendrites() {
        if (actionPotential > NO_POTENTIAL) {
            outgoingDendrites.stream().forEach(synapse -> synapse.propagateSpike(SPIKE));
            resetActionPotential();
        }
    }

    public boolean spiked() {
        return spiked;
    }

    public Double getSpikeTime() {
        return spikeTime;
    }
}

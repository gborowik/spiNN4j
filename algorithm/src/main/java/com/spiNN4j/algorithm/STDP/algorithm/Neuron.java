package com.spiNN4j.algorithm.STDP.algorithm;

import com.spiNN4j.model.data.Pair;
import com.spiNN4j.model.types.NeuronTypes.Izhikevich;

import java.util.HashSet;
import java.util.Set;

import static com.spiNN4j.algorithm.STDP.configurator.NeuronConfigurator.ACTIVATION_THRESHOLD;
import static com.spiNN4j.algorithm.STDP.configurator.NeuronConfigurator.TIME_STEP;
import static com.spiNN4j.model.types.ActionPotential.NO_POTENTIAL;
import static com.spiNN4j.model.types.NeuronTypes.Izhikevich.TONIC_SPIKING;

/**
 * Created by Grzegorz Borowik on 2016-06-23 6:16 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Neuron {

    private Double current;

    private Double V = -65.0d;
    private Double u = 0.0d;

    private Pair<Double> VAndU = new Pair<>(V, u);

    private boolean spiked;
    private Double spikeTime;

    protected Set<Synapse> incomingSynapses = new HashSet<>();
    protected Set<Synapse> outgoingSynapses = new HashSet<>();
    private Double activationThreshold = ACTIVATION_THRESHOLD;

    Izhikevich izhikevich = TONIC_SPIKING;
    private Double timeStep = TIME_STEP;


    public Neuron addSynapseToNeuron(Synapse synapse) {
        this.incomingSynapses.add(synapse);
        return this;
    }

    public Neuron addSynapseFromNeuron(Synapse synapse) {
        this.outgoingSynapses.add(synapse);
        return this;
    }

    public void resetPotential() {
        current = NO_POTENTIAL;
    }

    public void receiveSpike(Double weight) {
        current += weight;
    }

    public boolean checkMembranePotential(Double time) {
        spiked = izhikevich.tick(VAndU, current, activationThreshold, timeStep);
        if (spiked) {
            spikeTime = time;
        }
        return spiked;
    }

    public void propagateSpikesToOutgoingSynapses() {
        outgoingSynapses.stream().forEach(synapse -> synapse.propagateSpike());
    }

    public void updateWeightForIncomingSynapses() {
        incomingSynapses.stream().forEach(synapse -> synapse.updateWeight());
    }

    public void updateWeightForOutgoingSynapses() {
        outgoingSynapses.stream().forEach(synapse -> synapse.updateWeight());
    }

    public boolean spiked() {
        return spiked;
    }

    public Double getSpikeTime() {
        return spikeTime;
    }
}

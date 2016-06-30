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

    private Double potential;

    private Double V = 0.0d;
    private Double u = 0.0d;

    private Pair<Double> VAndU = new Pair<>(V, u);

    private boolean spiked;
    private Double spikeTime;

    protected Set<Synapse> incomingDendrites = new HashSet<>();
    protected Set<Synapse> outgoingDendrites = new HashSet<>();
    private Double activationThreshold = ACTIVATION_THRESHOLD;

    Izhikevich izhikevich = TONIC_SPIKING;
    private Double timeStep = TIME_STEP;


    public Neuron addDendriteToNeuron(Synapse synapse) {
        this.incomingDendrites.add(synapse);
        return this;
    }

    public Neuron addDendriteFromNeuron(Synapse synapse) {
        this.outgoingDendrites.add(synapse);
        return this;
    }

    public void resetPotential() {
        potential = NO_POTENTIAL;
    }

    public void receiveSpike(Double voltage) {
        potential += voltage;
    }

    public void checkMembranePotentialForAction(Double time) {
        spiked = izhikevich.tick(VAndU, potential, activationThreshold, timeStep);
        if (spiked) {
            spikeTime = time;
        }
    }

    public void propagateSpikesToDendrites() {
        if (spiked) {
            outgoingDendrites.stream().forEach(synapse -> synapse.propagateSpike(V));
        }
    }

    public boolean spiked() {
        return spiked;
    }

    public Double getSpikeTime() {
        return spikeTime;
    }
}

package com.spiNN4j.algorithm.STDP.algorithm;

import static java.lang.Math.exp;

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
       if(preSynapticNeuron.spiked() || postSynapticNeuron.spiked()){
           update();
       }
    }

    private void update(){
        final Double deltaT = preSynapticNeuron.getSpikeTime() - postSynapticNeuron.getSpikeTime();

        if (deltaT < 0.0d) {
            delta_w = W_plus * exp(deltaT / tau_plus)
                    * learningRate;
        } else if (deltaT > 0) {
            delta_w = -W_minus * exp(-deltaT / tau_minus)
                    * learningRate;
        }
        if(Math.signum(str) == -1) {
            synapse.setStrength(str - delta_w);
        } else {
            synapse.setStrength(str + delta_w);
        }
    }
}

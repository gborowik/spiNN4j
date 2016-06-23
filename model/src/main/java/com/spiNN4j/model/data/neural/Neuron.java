package com.spiNN4j.model.data.neural;

import java.util.Set;

/**
 * Created by Grzegorz Borowik on 2016-06-23 4:52 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public abstract class Neuron {

    protected Set<Synapse> preSynapses;
    protected Set<Synapse> postSynapses;

    public Neuron addPreSynapse(Synapse synapse) {
        this.preSynapses.add(synapse);
        return this;
    }

    public Neuron addPostSynapse(Synapse synapse) {
        this.postSynapses.add(synapse);
        return this;
    }

}

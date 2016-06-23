package com.spiNN4j.model.data.neural;

import java.util.Set;

/**
 * Created by Grzegorz Borowik on 2016-06-23 4:52 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Neuron {

    private Set<Synapse> preSynapses;
    private Set<Synapse> postSynapses;

    public Neuron addPreSynapse(Synapse synapse) {
        preSynapses.add(synapse);
        return this;
    }

    public Neuron addPostSynapse(Synapse synapse) {
        postSynapses.add(synapse);
        return this;
    }


}

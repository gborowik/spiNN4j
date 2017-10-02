package com.spiNN4j.algorithm.DESNN.algorithm;

import com.spiNN4j.algorithm.STDP.algorithm.Neuron;
import com.spiNN4j.algorithm.STDP.model.Network;
import com.spiNN4j.model.data.Position;

/**
 * Created by Grzegorz Borowik on 2016-07-06 3:25 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class OutputNetwork extends Network {

    private Neuron neuron;

    @Override
    public void tick() {

    }

    public void createNewOutputNeuron(Network middleNetwork){
        neuron = new Neuron(new Position(0.0,0.0,0.0));

        addNeuron(neuron);
    }

    public void nazwa(Network middleNetwork){


    }


}

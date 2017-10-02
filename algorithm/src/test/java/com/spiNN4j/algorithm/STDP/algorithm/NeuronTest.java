package com.spiNN4j.algorithm.STDP.algorithm;

import com.spiNN4j.model.data.Position;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by Grzegorz Borowik on 2016-07-01 10:41 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class NeuronTest {
    @Test
    public void checkMembranePotential() throws Exception {
        Neuron neuron = new Neuron(new Position(0.0, 0.0,0.0));

        neuron.receiveSpike(10d);

        assertThat(!neuron.updatePotentialAndCheckIfFired(10d));
    }

}
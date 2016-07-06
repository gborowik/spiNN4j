package com.spiNN4j.algorithm.STDP.algorithm;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by Grzegorz Borowik on 2016-07-01 10:41 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class NeuronTest {
    @Test
    public void checkMembranePotential() throws Exception {
        Neuron neuron = new Neuron();

        neuron.receiveSpike(10d);

        assertThat(neuron.updatePotentialAndCheckIfFired(10d) == false);
    }

}
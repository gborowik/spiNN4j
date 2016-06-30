package com.spiNN4j.model.types.NeuronTypes;

/**
 * Created by Grzegorz Borowik on 2016-06-27 3:52 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public enum Izhikevich {

    TONIC_SPIKING('A', 0.02d, 0.2d, -65.0d, 6.0d, 14.0d, -70.0d, 100.0d),
    PHASIC_SPIKING('B', 0.02d, 0.25d, -65.0d, 6.0d, 0.5d, -64.0d, 200.0d),
    TONIC_BURSTING('C', 0.02d, 0.2d, -50.0d, 2.0d, 15.0d, -70.0d, 220.0d),
    PHASIC_BURSTING('D', 0.02d, 0.25d, -55.0d, 0.05d, 0.6d, -64.0d, 200.0d),
    MIXED_MODE('E', 0.02d, 0.2d, -55.0d, 4.0d, 10.0d, -70.0d, 160.0d),
    SPIKE_FREQ_ADAPT('F', 0.01d, 0.2d, -65.0d, 8.0d, 30.0d, -70.0d, 85.0d),
    CLASS_1('G', 0.02d, -0.1d, -55.0d, 6.0d, 0d, -60.0d, 300.0d),
    CLASS_2('H', 0.2d, 0.26d, -65.0d, 0.0d, 0d, -64.0d, 300.0d),
    SPIKE_LATENCY('I', 0.02d, 0.2d, -65.0d, 6.0d, 7.0d, -70.0d, 100.0d),
    SUBTHRESH_OSC('J', 0.05d, 0.26d, -60.0d, 0.0d, 0d, -62.0d, 200.0d),
    RESONATOR('K', 0.1d, 0.26d, -60.0d, -1.0d, 0d, -62.0d, 400.0d),
    INTEGRATOR('L', 0.02d, -0.1d, -55.0d, 6.0d, 0d, -60.0d, 100.0d),
    REBOUND_SPIKE('M', 0.03d, 0.25d, -60.0d, 4.0d, -15d, -64.0d, 200.0d),
    REBOUND_BURST('N', 0.03d, 0.25d, -52.0d, 0.0d, -15d, -64.0d, 200.0d),
    THRESH_VAR('O', 0.03d, 0.25d, -60.0d, 4.0d, 0d, -64.0d, 100.0d),
    BISTABLE('P', 0.1d, 0.26d, -60.0d, 0.0d, 1.24d, -61.0d, 300.0d),
    DAP('Q', 1.15d, 0.2d, -60.0d, -21.0d, 20d, -70.0d, 50.0d),
    ACCOMMODATION('R', 0.02d, 1.0d, -55.0d, 4.0d, 0d, -65.0d, 400.0d),
    IISPIKE('S', -0.02d, -1.0d, -60.0d, 8.0d, 75.0d, -63.8d, 350.0d),
    IIBURST('T', -0.026d, -1.0d, -45.0d, 0.0d, 75.0d, -63.8d, 350.0d);

    Izhikevich(char id, Double a, Double b, Double c, Double d, Double I, Double V, Double tspan) {
    }
}

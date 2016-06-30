package com.spiNN4j.model.types.NeuronTypes;

import com.spiNN4j.model.data.Pair;

/**
 * Created by Grzegorz Borowik on 2016-06-27 3:52 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public enum Izhikevich {

    TONIC_SPIKING(0.02d, 0.2d, -65.0d, 6.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.TONIC_SPIKING;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    PHASIC_SPIKING(0.02d, 0.25d, -65.0d, 6.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.PHASIC_SPIKING;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    TONIC_BURSTING(0.02d, 0.2d, -50.0d, 2.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.TONIC_BURSTING;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    PHASIC_BURSTING(0.02d, 0.25d, -55.0d, 0.05d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.PHASIC_BURSTING;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    MIXED_MODE(0.02d, 0.2d, -55.0d, 4.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.MIXED_MODE;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    SPIKE_FREQ_ADAPT(0.01d, 0.2d, -65.0d, 8.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.SPIKE_FREQ_ADAPT;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    CLASS_1(0.02d, -0.1d, -55.0d, 6.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.CLASS_1;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (4.1d * V) + 108d - u + I));
        }
    },
    CLASS_2(0.2d, 0.26d, -65.0d, 0.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.CLASS_2;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    SPIKE_LATENCY(0.02d, 0.2d, -65.0d, 6.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.SPIKE_LATENCY;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    SUBTHRESH_OSC(0.05d, 0.26d, -60.0d, 0.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.SUBTHRESH_OSC;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    RESONATOR(0.1d, 0.26d, -60.0d, -1.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.RESONATOR;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    INTEGRATOR(0.02d, -0.1d, -55.0d, 6.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.INTEGRATOR;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (4.1d * V) + 108d - u + I));
        }
    },
    REBOUND_SPIKE(0.03d, 0.25d, -60.0d, 4.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.REBOUND_SPIKE;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    REBOUND_BURST(0.03d, 0.25d, -52.0d, 0.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.REBOUND_BURST;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    THRESH_VAR(0.03d, 0.25d, -60.0d, 4.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.THRESH_VAR;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    BISTABLE(0.1d, 0.26d, -60.0d, 0.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.BISTABLE;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    DAP(1.15d, 0.2d, -60.0d, -21.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.DAP;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    ACCOMMODATION(0.02d, 1.0d, -55.0d, 4.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.ACCOMMODATION;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    IISPIKE(-0.02d, -1.0d, -60.0d, 8.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.IISPIKE;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    },
    IIBURST(-0.026d, -1.0d, -45.0d, 0.0d) {
        @Override
        protected Izhikevich getType() {
            return Izhikevich.IIBURST;
        }

        @Override
        protected Double activationFunction(Double V, Double u, Double I, Double tau) {
            return (tau * ((0.04d * V * V) + (5d * V) + 140d - u + I));
        }
    };


    private final Double a;
    private final Double b;
    private final Double c;
    private final Double d;

    Izhikevich(Double a, Double b, Double c, Double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    protected abstract Izhikevich getType();

    protected abstract Double activationFunction(Double V, Double u, Double I, Double tau);

    private Double recoveryFunction(Double V, Double u, Double tau) {
        return (tau * this.a * (this.b * V - u));
    }

    public boolean tick(Pair<Double> VAndU, Double I, Double activationThreshold, Double tau) {

        Double newV = this.getType().activationFunction(VAndU.first, VAndU.second, I, tau);
        Double newU = recoveryFunction(VAndU.first, VAndU.second, tau);

        if (newV >= activationThreshold) {
            VAndU.first = this.c;
            VAndU.second += this.d;
            return true;
        } else {
            VAndU.first = newV;
            VAndU.second = newU;
            return false;
        }
    }


}

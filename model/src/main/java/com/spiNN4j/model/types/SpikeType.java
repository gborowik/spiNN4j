package com.spiNN4j.model.types;

/**
 * Created by Grzegorz Borowik on 2016-06-20 4:11 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public enum SpikeType {
    NEGATIVE_SPIKE {
        @Override
        public SpikeType getSpikeType() {
            return SpikeType.NEGATIVE_SPIKE;
        }

        @Override
        protected boolean isSpikeType(double signalDifference, double threshold) {
            return signalDifference < -threshold;
        }
    },
    POSITIVE_SPIKE {
        @Override
        public SpikeType getSpikeType() {
            return SpikeType.POSITIVE_SPIKE;
        }

        @Override
        protected boolean isSpikeType(double signalDifference, double threshold) {
            return signalDifference > threshold;
        }
    },
    NO_SPIKE {
        @Override
        public SpikeType getSpikeType() {
            return SpikeType.NO_SPIKE;
        }

        @Override
        protected boolean isSpikeType(double signalDifference, double threshold) {
            return (-threshold <= signalDifference) && (signalDifference <= threshold);
        }
    };

    public abstract SpikeType getSpikeType();

    protected abstract boolean isSpikeType(double signalDifference, double threshold);

    public static SpikeType generateSpike(Double signal, Double threshold) {
        for (SpikeType spikeType : SpikeType.values()) {
            if (spikeType.isSpikeType(signal, threshold)) {
                return spikeType.getSpikeType();
            }
        }
        throw new RuntimeException("Cannot generate spike");
    }
}

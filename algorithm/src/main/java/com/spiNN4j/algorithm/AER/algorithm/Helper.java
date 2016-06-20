package com.spiNN4j.algorithm.AER.algorithm;

import com.codepoetics.protonpack.StreamUtils;
import com.spiNN4j.model.types.SpikeType;
import com.spiNN4j.model.data.DataMatrix;
import com.spiNN4j.model.data.DataVector;
import one.util.streamex.StreamEx;

import java.util.List;
import java.util.stream.Collectors;

import static com.spiNN4j.model.types.SpikeType.generateSpike;

/**
 * Created by Grzegorz Borowik on 2016-06-20 4:08 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Helper {

    public DataMatrix<SpikeType> generateSpikesForSuccessiveRowsOfSample(
            DataMatrix<Double> data,
            DataVector<Double> threshold
    ) {
        List<DataVector<SpikeType>> spikes = StreamEx.of(data.getData())
                .pairMap((first, second) -> generateSpikesForTwoRowsOfSample(first, second, threshold))
                .collect(Collectors.toList());

        return new DataMatrix<>(spikes, spikes.get(0).size());
    }

    private DataVector<SpikeType> generateSpikesForTwoRowsOfSample(
            DataVector<Double> first,
            DataVector<Double> second,
            DataVector<Double> threshold
    ) {
        return new DataVector<>(StreamUtils.zip(
                first.getData().stream(), second.getData().stream(), threshold.getData().stream(),
                (fir, sec, tr) -> generateSpike(sec - fir, tr))
                .collect(Collectors.toList()));
    }
}

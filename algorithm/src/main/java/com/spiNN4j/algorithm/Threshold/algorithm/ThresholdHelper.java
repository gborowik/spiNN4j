package com.spiNN4j.algorithm.threshold.algorithm;

import com.codepoetics.protonpack.StreamUtils;
import com.spiNN4j.model.data.DataMatrix;
import com.spiNN4j.model.data.DataVector;
import one.util.streamex.StreamEx;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by Grzegorz Borowik on 2016-06-19 2:40 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class ThresholdHelper {

    public static DataMatrix<Double> absoluteDifferenceBetweenSuccessiveRows(DataMatrix<Double> data) {
        List<DataVector<Double>> differences = StreamEx.of(data.getData())
                .pairMap((first, second) -> absoluteDifferenceBetweenRows(first, second))
                .collect(Collectors.toList());

        return new DataMatrix<>(differences, differences.get(0).size());
    }

    private static DataVector<Double> absoluteDifferenceBetweenRows(DataVector<Double> first, DataVector<Double> second) {
        return new DataVector<>(StreamUtils.zip(
                first.getData().stream(), second.getData().stream(),
                (a, b) -> abs(a - b))
                .collect(Collectors.toList()));
    }

    public static DataVector<Double> multiplyRowByValue(DataVector<Double> vector, Double value) {
        return new DataVector<>(vector.getData().stream()
                .map(el -> el * value)
                .collect(Collectors.toList()));
    }

    public static DataVector<Double> sumOfTwoRows(DataVector<Double> first, DataVector<Double> second) {
        return new DataVector<>(StreamUtils.zip(
                first.getData().stream(), second.getData().stream(),
                (a, b) -> a + b)
                .collect(Collectors.toList()));
    }
}

package com.spiNN4j.algorithm.AER.statistics;

import com.codepoetics.protonpack.StreamUtils;
import com.spiNN4j.model.data.DataMatrix;
import com.spiNN4j.model.data.DataVector;
import one.util.streamex.StreamEx;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

/**
 * Created by Grzegorz Borowik on 2016-06-17 2:54 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class AERHelper {

    DataMatrix<Double> absoluteDifferenceBetweenSuccessiveRows(DataMatrix<Double> data) {

        List<DataVector<Double>> differences = StreamEx.of(data.getData())
                .pairMap((first, second) -> absoluteDifferenceBetweenRows(first, second))
                .collect(Collectors.toList());

        return new DataMatrix<>(differences, differences.get(0).size());
    }

    private DataVector<Double> absoluteDifferenceBetweenRows(DataVector<Double> first, DataVector<Double> second) {
        return new DataVector<>(StreamUtils.zip(
                first.getData().stream(), second.getData().stream(),
                (a, b) -> abs(a - b))
                .collect(Collectors.toList()));
    }

    DataVector<Double> arithmeticMeanForColumns(DataMatrix<Double> data) {
        DataVector<Double> rowOfZeros = new DataVector<>(data.getWidth());
        rowOfZeros.fill(0.0);

        return new DataVector<>(
                data.getData().stream()
                        .reduce(rowOfZeros, (first, second) -> sumOfTwoRows(first, second))
                        .getData().stream()
                        .map(el -> el / data.size())
                        .collect(Collectors.toList()));
    }

    public DataVector<Double> sumOfTwoRows(DataVector<Double> first, DataVector<Double> second) {
        return new DataVector<>(StreamUtils.zip(
                first.getData().stream(), second.getData().stream(),
                (a, b) -> a + b)
                .collect(Collectors.toList()));
    }

    DataVector<Double> standardDeviationForColumns(DataMatrix<Double> data) {
        final ArrayList<Double> vector = new ArrayList<>();

        for (int column = 0; column < data.getWidth(); column++) {
            vector.add(standardDeviationForColumn(data, column));
        }

        return new DataVector<>(vector);
    }

    private Double standardDeviationForColumn(DataMatrix<Double> data, int column) {
        final DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

        data.getData().stream().forEach(row -> descriptiveStatistics.addValue(row.get(column)));

        return descriptiveStatistics.getStandardDeviation();
    }

    DataVector<Double> multiplyVectorByValue(DataVector<Double> vector, Double value){
        return new DataVector<>(vector.getData().stream()
                .map(el -> el * value)
                .collect(Collectors.toList()));
    }

}

package com.spiNN4j.algorithm.threshold.algorithm;

import com.spiNN4j.model.data.DataMatrix;
import com.spiNN4j.model.data.DataVector;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.spiNN4j.algorithm.threshold.algorithm.ThresholdHelper.sumOfTwoRows;

/**
 * Created by Grzegorz Borowik on 2016-06-17 2:54 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Statistics {

    public static DataVector<Double> arithmeticMeanForColumns(DataMatrix<Double> data) {
        DataVector<Double> rowOfZeros = new DataVector<>(data.getWidth(), 0.0);

        return new DataVector<>(
                data.getData().stream()
                        .reduce(rowOfZeros, (first, second) -> sumOfTwoRows(first, second))
                        .getData().stream()
                        .map(el -> el / data.size())
                        .collect(Collectors.toList()));
    }

    public static DataVector<Double> standardDeviationForColumns(DataMatrix<Double> data) {
        final ArrayList<Double> vector = new ArrayList<>();

        for (int column = 0; column < data.getWidth(); column++) {
            vector.add(standardDeviationForColumn(data, column));
        }

        return new DataVector<>(vector);
    }

    private static Double standardDeviationForColumn(DataMatrix<Double> data, int column) {
        final DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();

        data.getData().stream().forEach(row -> descriptiveStatistics.addValue(row.get(column)));

        return descriptiveStatistics.getStandardDeviation();
    }
}

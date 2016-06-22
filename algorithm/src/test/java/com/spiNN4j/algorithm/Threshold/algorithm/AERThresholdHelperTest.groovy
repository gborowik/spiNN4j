package com.spiNN4j.algorithm.threshold.algorithm

import com.spiNN4j.model.data.DataMatrix
import com.spiNN4j.model.data.DataVector
import spock.lang.Specification

/**
 * Created by Grzegorz Borowik on 2016-06-19 6:40 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class AERThresholdHelperTest extends Specification {

    ThresholdHelper helper = new ThresholdHelper()

    def "Should return absoluteDifferenceBetweenSuccessiveRows"() {
        when:
        DataMatrix<Double> result = helper.absoluteDifferenceBetweenSuccessiveRows(toDataMatrix(matrix));

        then:
        result == toDataMatrix(expected)

        where:
        matrix             | expected
        [[1d], [1d]]       | [[0d]]
        [[1d], [1d], [1d]] | [[0d], [0d]]
        [[5d], [3d], [7d]] | [[2d], [4d]]
    }

    DataMatrix<?> toDataMatrix(List<List<?>> data) {
        int width = data.first()?.size() ?: 2
        return new DataMatrix<?>(data.collect {
            new DataVector<?>(it)
        }, width)
    }

    def "Should return multiplyRowByValue"() {
        when:
        List<Double> result = helper.multiplyRowByValue(new DataVector<>(vector), value).getData();

        then:
        result == expected

        where:
        vector                     | value  | expected
        []                         | null   | []
        []                         | 2.3d   | []
        [1.0d]                     | 0.0d   | [0.0d]
        [1.0d, 4.2d]               | 0.0d   | [0.0d, 0.0d]
        [0.0d]                     | 4.2d   | [0.0d]
        [3.4d, 4.8d]               | 2.5d   | [8.5d, 12.0d]
        [-0.5d]                    | 0.5d   | [-0.25d]
        [-3.1d, 8.4d, -2.2d, -18d] | 9.2d   | [-28.52d, 77.28d, -20.24d, -165.6d]
        [-3.1d, 8.4d, -2.2d, -8d]  | -16.2d | [50.22d, -136.08d, 35.64d, 129.6d]
    }

    def "Should return sumOfTwoRows"() {
        when:
        List<Double> result = helper.sumOfTwoRows(new DataVector<>(vector1), new DataVector<>(vector2)).getData();

        then:
        result == expected

        where:
        vector1                    | vector2                   | expected
        []                         | []                        | []
        []                         | [2.3d]                    | []
        [1.0d]                     | [0.0d]                    | [1.0d]
        [1.0d, 4.2d]               | [0.0d]                    | [1.0d]
        [0.0d]                     | [1.0d, 4.2d]              | [1.0d]
        [1.4d, 0.3d]               | [1.5d, 4.2d]              | [2.9d, 4.5d]
        [-0.5d]                    | [0.5d]                    | [0.0d]
        [-3.1d, 8.4d, -2.2d, -18d] | [4.2d, 1.9d, -3.5d, 9.2d] | [1.1d, 10.3d, -5.7d, -8.8d]
    }
}
package com.spiNN4j.algorithm.AER.algorithm

import com.spiNN4j.model.data.DataMatrix
import com.spiNN4j.model.data.DataVector
import com.spiNN4j.model.types.SpikeType
import spock.lang.Specification

import static com.spiNN4j.model.types.SpikeType.NEGATIVE_SPIKE
import static com.spiNN4j.model.types.SpikeType.NO_SPIKE
import static com.spiNN4j.model.types.SpikeType.POSITIVE_SPIKE

/**
 * Created by Grzegorz Borowik on 2016-06-20 6:10 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class AERThresholdHelperTest extends Specification {

    AERHelper helper = new AERHelper()

    def "Should generateSpikesForSuccessiveRowsOfSample"() {
        when:
        DataMatrix<SpikeType> result = helper.generateSpikesForSuccessiveRowsOfSample(toDataMatrix(matrix), new DataVector<>(threshold));

        then:
        result == toDataMatrix(expected)

        where:
        matrix             | threshold | expected
        [[1d], [1d]]       | [0d]      | [[NO_SPIKE]]
        [[1d], [1d], [1d]] | [0d]      | [[NO_SPIKE], [NO_SPIKE]]
        [[5d], [3d], [7d]] | [1d]      | [[NEGATIVE_SPIKE], [POSITIVE_SPIKE]]
    }

    DataMatrix<?> toDataMatrix(List<List<?>> data) {
        int width = data.first()?.size() ?: 2
        return new DataMatrix<?>(data.collect {
            new DataVector<?>(it)
        }, width)
    }

    def "Should generateSpikesForTwoRowsOfSample"() {
        when:
        List<SpikeType> result = helper.generateSpikesForTwoRowsOfSample(
                new DataVector<>(first), new DataVector<>(second), new DataVector<>(threshold))
                .getData();

        then:
        result == expected

        where:
        first                      | second                    | threshold                | expected
        []                         | []                        | []                       | []
        []                         | [2.3d]                    | []                       | []
        [1.0d]                     | [0.0d]                    | [0.5d]                   | [NEGATIVE_SPIKE]
        [1.0d, 4.2d]               | [0.0d]                    | [0.5d]                   | [NEGATIVE_SPIKE]
        [0.0d]                     | [1.0d, 4.2d]              | [0.5d]                   | [POSITIVE_SPIKE]
        [1.4d, 0.3d]               | [1.5d, 4.2d]              | [0.2d, 4d]               | [NO_SPIKE, NO_SPIKE]
        [-0.5d]                    | [0.5d]                    | [0.05d]                  | [POSITIVE_SPIKE]
        [-3.1d, 8.4d, -2.2d, -18d] | [4.2d, 1.9d, -3.5d, 9.2d] | [0.1d, 0.2d, 0.1d, 0.2d] | [POSITIVE_SPIKE, NEGATIVE_SPIKE, NEGATIVE_SPIKE, POSITIVE_SPIKE]
        [5d]                       | [3d]                      | [0.1d]                   | [NEGATIVE_SPIKE]
        [3d]                       | [5d]                      | [0.1d]                   | [POSITIVE_SPIKE]
        [-5d]                      | [-3d]                     | [0.1d]                   | [POSITIVE_SPIKE]
        [-3d]                      | [-5d]                     | [0.1d]                   | [NEGATIVE_SPIKE]
    }
}
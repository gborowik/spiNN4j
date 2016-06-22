package com.spiNN4j.algorithm.threshold.algorithm

import com.spiNN4j.model.data.DataMatrix
import com.spiNN4j.model.data.DataVector
import spock.lang.Specification

/**
 * Created by Grzegorz Borowik on 2016-06-19 11:29 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class StatisticsTest extends Specification {

    Statistics statistics = new Statistics();

    def "Should return arithmeticMeanForColumns"() {
        when:
        List<Double> result = statistics.arithmeticMeanForColumns(toDataMatrix(matrix)).getData();

        then:
        result == expected

        where:
        matrix                         | expected
        [[5d], [3d], [7d]]             | [5d]
        [[5d, 2d], [3d, 7d], [7d, 3d]] | [5d, 4d]
    }

    def "Should return standardDeviationForColumns"() {
        when:
        List<Double> result = statistics.standardDeviationForColumns(toDataMatrix(matrix)).getData();

        then:
        result == expected

        where:
        matrix                         | expected
        [[5d], [3d], [7d]]             | [2d]
        [[5d, 2d], [3d, 7d], [7d, 3d]] | [2d, 2.6457513110645907d]
    }

    DataMatrix<Double> toDataMatrix(List<List<Double>> data) {
        int width = data.first()?.size() ?: 2
        return new DataMatrix<Double>(data.collect {
            new DataVector<Double>(it)
        }, width)
    }

}
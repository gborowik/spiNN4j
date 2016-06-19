package com.spiNN4j.algorithm.Threshold.algorithm

import com.spiNN4j.model.data.DataVector
import spock.lang.Specification

/**
 * Created by Grzegorz Borowik on 2016-06-19 6:40 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class HelperTest extends Specification {

    Helper helper = new Helper()

    def "Should return absoluteDifferenceBetweenSuccessiveRows"() {

    }

    def "Should return multiplyRowByValue"() {

    }

    def "Should return sumOfTwoRows"() {
        when:
        List<Double> result = helper.sumOfTwoRows(new DataVector<>(vector1), new DataVector<>(vector2)).getData();

        then:
        result == expected

        where:
        vector1 | vector2 | expected
        [1.0]   | [0.0]   | [1.0]
    }
}
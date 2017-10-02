package com.spiNN4j.algorithm.graph.algorithm

import com.spiNN4j.model.data.Pair
import spock.lang.Specification

class AllPairsTest extends Specification {
    def "AllPairs should return all pairs"() {
        given:
        List<String> allPairs = AllPairs.allPairs(list).collect(this.&concat)
        expect:
        allPairs.containsAll(expected)
        where:
        list            | expected
        ['1', '2']      | ['1 2']
        ['1']           | []
        ['1', '2', '3'] | ['1 2', '1 3', '2 3']
    }

    def "AllPairs should have a proper number of elements"() {
        given:
        List<String> allPairs = AllPairs.allPairs(list).collect(this.&concat)
        expect:
        allPairs.size() == expected
        where:
        list       | expected
        ['1'] * 1  | 0
        ['1'] * 2  | 2 * 1 / 2
        ['1'] * 3  | 3 * 2 / 2
        ['1'] * 4  | 4 * 3 / 2
        ['1'] * 20 | 20 * 19 / 2
    }

    private static String concat(Pair<String> pair) {
        return "${pair.first} ${pair.second}".toString()
    }
}

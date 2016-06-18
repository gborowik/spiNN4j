package com.spiNN4j.model.data

import spock.lang.Specification

import static AllSuccessivePairs.allSuccessivePairs

/**
 * Created by Grzegorz Borowik on 2016-06-18 6:23 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
class AllSuccessivePairsTest extends Specification {
    def "AllSuccessivePairs should return all successive pairs"() {
        given:
        List<String> allPairs = allSuccessivePairs(list).collect(this.&concat)
        expect:
        allPairs.containsAll(expected)
        where:
        list                      | expected
        ['1', '2']                | ['1 2']
        ['1']                     | []
        []                        | []
        ['1', '2', '3']           | ['1 2', '2 3']
        ['1', '2', '3', '4']      | ['1 2', '2 3', '3 4']
        ['5', '3', '6', '2', '0'] | ['5 3', '3 6', '6 2', '2 0']
    }

    def "AllPairs should have a proper number of elements"() {
        given:
        List<String> allPairs = allSuccessivePairs(list).collect(this.&concat)
        expect:
        allPairs.size() == expected
        where:
        list       | expected
        ['1'] * 1  | 0
        ['1'] * 2  | 1
        ['1'] * 3  | 2
        ['1'] * 4  | 3
        ['1'] * 20 | 19
    }

    private String concat(AllSuccessivePairs.Pair<String> pair) {
        return "${pair.first} ${pair.second}".toString()
    }
}

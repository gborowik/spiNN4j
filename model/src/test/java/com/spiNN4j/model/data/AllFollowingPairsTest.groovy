package com.spiNN4j.model.data

import spock.lang.Specification

import static com.spiNN4j.model.data.AllFollowingPairs.allFollowingPairs

class AllFollowingPairsTest extends Specification {
    def "AllFollowingPairs should return all following pairs"() {
        given:
        List<String> allPairs = allFollowingPairs(list).collect(this.&concat)
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
        List<String> allPairs = allFollowingPairs(list).collect(this.&concat)
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

    private String concat(AllFollowingPairs.Pair<String> pair) {
        return "${pair.first} ${pair.second}".toString()
    }
}

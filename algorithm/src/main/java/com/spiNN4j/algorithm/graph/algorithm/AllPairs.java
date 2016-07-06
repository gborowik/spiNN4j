package com.spiNN4j.algorithm.graph.algorithm;

import com.spiNN4j.model.data.Pair;

import java.util.Iterator;
import java.util.List;

public class AllPairs {
    /**
     * Generates lazy iterable of all possible pairs of elements for a given list.
     * <p>
     * Complexity: Obtaining all pairs has complexity O(n^2).
     * <p>
     * Remark 1: Returned pair changes when next() is called on iterator!!!
     *
     * @param list a list of elements for which subsequent pairs are delivered
     * @return lazy iterable
     */
    public static <T> Iterable<Pair<T>> allPairs(final List<T> list) {

        /*
         * Overriden Iterator in Iterable
         */
        return () -> new Iterator<Pair<T>>() {
            int firstIndex = 0;
            int secondIndex = 0;
            final Pair<T> current = new Pair<>(list.get(0), list.get(0));

            @Override
            public boolean hasNext() {
                return secondIndex < list.size() - 1 || firstIndex < list.size() - 2;
            }

            /**
             * Overrides {@code next()} in Iterator.
             * @return subsequent pair of elements
             * (of type {@code T}) in the iteration.
             */
            @Override
            public Pair<T> next() {
                if (secondIndex < list.size() - 1) {
                    secondIndex++;
                    current.second = list.get(secondIndex);
                } else {
                    firstIndex++;
                    secondIndex = firstIndex + 1;
                    current.first = list.get(firstIndex);
                    current.second = list.get(secondIndex);
                }
                return current;
            }
        };
    }
}

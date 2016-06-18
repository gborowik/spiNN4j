package com.spiNN4j.model.data;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Grzegorz Borowik on 2016-06-18 4:50 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class AllSuccessivePairs {
    /**
     * Generates lazy iterable of all successive pairs of elements for a given list.
     * <p>
     * Complexity: Obtaining all successive pairs has complexity O(n).
     * <p>
     * Remark 1: Returned pair changes when next() is called on iterator!!!
     *
     * @param list a list of elements for which pairs are delivered
     * @return lazy iterable
     */
    public static <T> Iterable<Pair<T>> allSuccessivePairs(final List<T> list) {

        return () -> new Iterator<Pair<T>>() {
            int firstIndex = -1;
            int secondIndex = 0;

            @Override
            public boolean hasNext() {
                return secondIndex < list.size() - 1;
            }

            /**
             * Overrides {@code next()} in Iterator.
             * @return subsequent pair of elements
             * (of type {@code T}) in the iteration.
             */
            @Override
            public Pair<T> next() {
                return new Pair<>(list.get(++firstIndex), list.get(++secondIndex));
            }
        };
    }

    public static class Pair<T> {
        public T first;
        public T second;

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }
    }
}

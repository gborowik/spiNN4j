package com.spiNN4j.model.data;

/**
 * Created by Grzegorz Borowik on 2016-06-23 1:27 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Pair<T> {
    public T first;
    public T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }
}

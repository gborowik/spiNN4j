package com.spiNN4j.model.data;

/**
 * Created by Grzegorz Borowik on 2016-06-22 3:59 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Triple<T> {
    protected T first;
    protected T second;
    protected T third;

    public Triple(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

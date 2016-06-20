package com.spiNN4j.runner;

import com.spiNN4j.model.types.AlgorithmType;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by Grzegorz Borowik on 2016-06-14 3:06 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Configurator implements Serializable, Closeable {

    protected AlgorithmType algorithmType;
    public Configurator algorithmType(AlgorithmType algorithmType) {
        this.algorithmType = algorithmType;
        return this;
    }


    protected String folder;
    public Configurator folder(String folder) {
        this.folder = folder;
        return this;
    }


    protected String fileMask;
    public Configurator fileMask(String fileMask) {
        this.fileMask = fileMask;
        return this;
    }


    @Override
    public void close() throws IOException {

    }
}

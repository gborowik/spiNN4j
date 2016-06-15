package com.spiNN4j.runner;

import com.spiNN4j.model.algorithm.Type;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by Grzegorz Borowik on 2016-06-14 3:06 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Configurator implements Serializable, Closeable {

    protected Type type;
    public Configurator algorithmType(Type type) {
        this.type = type;
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

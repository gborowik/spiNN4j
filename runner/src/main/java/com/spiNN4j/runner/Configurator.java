package com.spiNN4j.runner;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by Grzegorz Borowik on 2016-06-14 3:06 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class Configurator implements Serializable, Closeable {

    private boolean lazy;

    public Configurator() {
        lazy = false;
    }

    public Configurator lazy(){
        lazy = true;
        return this;
    }



    @Override
    public void close() throws IOException {

    }
}

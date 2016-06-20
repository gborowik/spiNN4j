package com.spiNN4j.runner;

import org.junit.Test;

import static com.spiNN4j.model.types.AlgorithmType.CLASSIFICATION;

/**
 * Created by Grzegorz Borowik on 2016-06-16 12:50 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class ConfiguratorTest {

    @Test
    public void shouldConfigure() throws Exception {

        Configurator configurator = new Configurator()
                .algorithmType(CLASSIFICATION)
                .folder(".")
                .fileMask("*");

    }


}
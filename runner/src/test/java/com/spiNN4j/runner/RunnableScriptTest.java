package com.spiNN4j.runner;

import org.junit.Test;

import java.io.FileInputStream;

/**
 * Created by Grzegorz Borowik on 2016-06-14 3:15 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class RunnableScriptTest {

    @Test
    public void inputStreamFrom() throws Exception {
        FileInputStream fileInputStream = RunnableScript.inputStreamFrom("asd");

        //assertThat(fileInputStream).isNotNull();
    }

}
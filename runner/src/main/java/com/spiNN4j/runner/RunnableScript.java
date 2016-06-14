package com.spiNN4j.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 * Created by Grzegorz Borowik on 2016-06-14 3:07 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class RunnableScript {



    public static FileInputStream inputStreamFrom(String name) {
        try {
            URL resource = RunnableScript.class.getResource(name);
            File file;
            if (resource == null)
                file = new File(name);
            else
                file = new File(resource.getFile());
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

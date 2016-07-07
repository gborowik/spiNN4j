package com.spiNN4j.runner;

import com.spiNN4j.io.ioManager.FolderManager;
import com.spiNN4j.io.model.StreamOfSamplesAsDouble;
import com.spiNN4j.io.parser.CSVParserDouble;
import groovy.lang.Script;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 * Created by Grzegorz Borowik on 2016-06-14 3:07 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public abstract class RunnableScript extends Script {

    public static StreamOfSamplesAsDouble getData(String folder, String mask) {

        return new StreamOfSamplesAsDouble(
                new FolderManager(folder)
                        .inputStreamsFilesMatch(mask)
                        .map(file -> new CSVParserDouble(file).parse())
        );

    }


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

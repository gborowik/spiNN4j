package com.spiNN4j.io.ioManager;

import org.junit.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by Grzegorz Borowik on 2016-06-15 2:12 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class FolderManagerTest {

    @Test
    public void shouldReturnNoFiles() throws Exception {

        List<String> fileList = new FolderManager()
                .filesAtPathMatch(",")
                .map(path -> path.getFileName().toString())
                .collect(Collectors.toList());

        assertThat(fileList).isEmpty();
    }
    
    @Test
    public void shouldReturnFilesAtMainPath() throws Exception {

        List<String> fileList = new FolderManager()
                .filesAtPath()
                .map(path -> path.getFileName().toString())
                .collect(Collectors.toList());

        assertThat(fileList).containsOnly(".DS_Store", "io.iml", "pom.xml");
    }

    @Test
    public void shouldReturnFilesWhichMatchPatternAtPath() throws Exception {

        List<String> fileList = new FolderManager("./src/main/java/com/spiNN4j/io/ioManager")
                .filesAtPathMatch("*.j*")
                .map(path -> path.getFileName().toString())
                .collect(Collectors.toList());

        assertThat(fileList).contains("FolderManager.java");
    }

    @Test
    public void shouldIterateFilesWhichMatchPatternAtPath() throws Exception {
        Iterator<Path> iterator = new FolderManager("./src/main/java/com/spiNN4j/io/ioManager")
                .filesAtPathMatch("*").iterator();

        List<String> fileList = new ArrayList<>();

        for (; iterator.hasNext(); ) {
            fileList.add(iterator
                    .next()
                    .getFileName()
                    .toString()
            );
        }

        assertThat(fileList).containsOnly("FolderManager.java");
    }

}
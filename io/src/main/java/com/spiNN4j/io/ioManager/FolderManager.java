package com.spiNN4j.io.ioManager;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Grzegorz Borowik on 2016-06-15 1:45 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class FolderManager {

    private Path path;

    public FolderManager() {
        this.path = Paths.get(".");
    }

    public FolderManager(String path) {
        this.path = Paths.get(path);
    }

    public Stream<Path> allFilesAtPath() {
        try {
            return Files.find(path, 1, (path, attrs) -> attrs.isRegularFile());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Stream<Path> allFilesAtPathMatch(String pattern) {
        try {
            PathMatcher matcher = FileSystems.getDefault()
                    .getPathMatcher("glob:" + pattern);

            return Files.find(path, 1, (path, attrs) -> attrs.isRegularFile() && matcher.matches(path.getFileName()));

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Stream<InputStream> inputStreamsFilesMatch(String pattern) {

        return allFilesAtPathMatch(pattern)
                .map(file -> {
                            try {
                                return Files.newInputStream(file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                );
    }

    public List<InputStream> listOfInputStreamsFilesMatch(String pattern) {

        List<InputStream> inputStreams = new ArrayList<>();

        allFilesAtPathMatch(pattern).forEach(file -> {
            try {
                inputStreams.add(Files.newInputStream(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return inputStreams;
    }


}

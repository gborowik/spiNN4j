package com.spiNN4j.io.ioManager;

import java.io.IOException;
import java.nio.file.*;
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

    public Stream<Path> filesAtPath() {
        try {
            return Files.find(path, 1, (path, attrs) -> attrs.isRegularFile());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Stream<Path> filesAtPathMatch(String pattern) {
        try {
            PathMatcher matcher = FileSystems.getDefault()
                    .getPathMatcher("glob:" + pattern);

            return Files.find(path, 1, (path, attrs) -> attrs.isRegularFile() && matcher.matches(path.getFileName()));

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}

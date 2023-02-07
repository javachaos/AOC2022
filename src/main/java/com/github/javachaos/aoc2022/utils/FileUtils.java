package com.github.javachaos.aoc2022.utils;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.stream.Stream;

public class FileUtils {
    private static BufferedReader fr;

    public static File getFileFromResource(String fileName) {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            try {
                return new File(resource.toURI());
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * !!! Warning Caller is responsible for closing this resource!!!
     *
     * @param f the file to read
     */
    public static Stream<String> lines(File f) throws FileNotFoundException {
        fr = new BufferedReader(new FileReader(f));
        return fr.lines();
    }
}

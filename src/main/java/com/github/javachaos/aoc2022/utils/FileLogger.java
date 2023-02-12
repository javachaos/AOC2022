package com.github.javachaos.aoc2022.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

public class FileLogger {
    private PrintWriter fw;
    private static final String LOG_FILENAME = "./logging.log";
    private static FileLogger instance;

    private FileLogger() {
        try {
            fw = new PrintWriter(logFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static FileLogger getLogger() {
        if (instance == null) {
            instance = new FileLogger();
        }
        return instance;
    }

    private File logFile() {
        File f = null;
        try {
            f = new File(LOG_FILENAME);
            if (!f.exists()) {
                if (f.createNewFile()) {
                    log("New logfile created.");
                } else {
                    log("Log file exists.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }

    private void write(String line) throws IOException {
        fw.println(line);
        fw.flush();
    }

    public void log(String line) {
        try {
            String logEntry = Instant.now() + "-[AOC2022]: " + line;
            write(logEntry);
            System.out.println(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logException(Throwable t) {
        log("Exception: " + t.getMessage());
    }
}

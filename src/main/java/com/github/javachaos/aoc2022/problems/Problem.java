package com.github.javachaos.aoc2022.problems;

import com.github.javachaos.aoc2022.utils.FileLogger;
import com.github.javachaos.aoc2022.utils.FileUtils;

import java.io.IOException;
import java.util.stream.Stream;

public abstract class Problem implements IProblem {


    protected Stream<String> inputData;

    protected final String problemName;
    public final FileLogger LOGGER = FileLogger.getLogger();

    public Problem(String problemName) {
        this.problemName = problemName;
    }
    /**
     * Initialize data structures not directly related to the problem.
     */
    protected abstract void init();

    protected void loadInputData(final String filename) {
        try {
            inputData = FileUtils.lines(FileUtils.getFileFromResource(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeProblem() {
        init();
        long start = System.nanoTime();
        long result = run();
        long end = System.nanoTime();
        LOGGER.log(problemName + ": COMPLETED");
        long ns = (end - start);
        LOGGER.log("RUNTIME (s) : "+ ((double) ns / 1000000000.0));
        LOGGER.log("RUNTIME (ms): "+ ((double) ns / 1000000.0));
        LOGGER.log("RUNTIME (µs): "+ ((double) ns / 1000.0));
        LOGGER.log("RUNTIME (ns): "+ ns);
        if ((int)(ns / 1000000.0) > 1000) {// Longer than 1 second run time.
            LOGGER.log("FAILED! Operation took too long, consider making it more efficient.");
        } else {
            LOGGER.log("RESULT: " + result);
        }

        done();
        if (inputData != null) {
            inputData.close();
        }
    }

    protected abstract void done();

    protected abstract long run();

}

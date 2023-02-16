package com.github.javachaos.aoc2022.problems;

import com.github.javachaos.aoc2022.utils.FileLogger;
import com.github.javachaos.aoc2022.utils.FileUtils;

import java.io.IOException;
import java.util.stream.Stream;

public abstract class Problem implements IProblem {

    protected Stream<String> inputData;
    protected final String problemName;
    public final FileLogger logger = FileLogger.getLogger();

    protected Problem(String problemName) {
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
    public String executeProblem() {
        init();
        long start = System.nanoTime();
        String result = run();
        long end = System.nanoTime();
        logger.log(problemName + ": COMPLETED");
        long ns = (end - start);
        logger.log("RUNTIME (s) : "+ (ns / 1000000000.0));
        logger.log("RUNTIME (ms): "+ (ns / 1000000.0));
        logger.log("RUNTIME (µs): "+ (ns / 1000.0));
        logger.log("RUNTIME (ns): "+ ns);
        if ((int)(ns / 1000000.0) > 1000) {// Longer than 1 second run time.
            logger.log("FAILED! Operation took too long, consider making it more efficient.");
        } else {
            logger.log("RESULT: " + result);
        }

        done();
        if (inputData != null) {
            inputData.close();
        }
        return result;
    }

    protected abstract void done();

    protected abstract String run();

}

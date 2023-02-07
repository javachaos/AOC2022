package com.github.javachaos.aoc2022.problems;

import com.github.javachaos.aoc2022.utils.FileLogger;

public abstract class Problem implements IProblem {

    private final String problemName;
    public final FileLogger LOGGER = FileLogger.getLogger();

    public Problem(String problemName) {
        this.problemName = problemName;
    }
    /**
     * Initialize data structures not directly related to the problem.
     */
    protected abstract void init();

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

        print(result);
        done();
    }

    protected abstract void done();

    protected abstract long run();

    protected void print(Number n) {
        LOGGER.log("RESULT: "+ n);
    }
}

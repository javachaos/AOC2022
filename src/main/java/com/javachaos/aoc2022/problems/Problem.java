package com.javachaos.aoc2022.problems;

import java.io.FileNotFoundException;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Problem implements IProblem {

    private final String problemName;

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
        System.out.println(problemName + ": COMPLETED");
        long ns = (end - start);
        System.out.println("RUNTIME (s) : "+ ((double) ns / 1000000000.0));
        System.out.println("RUNTIME (ms): "+ ((double) ns / 1000000.0));
        System.out.println("RUNTIME (µs): "+ ((double) ns / 1000.0));
        System.out.println("RUNTIME (ns): "+ ns);

        print(result);
        done();
    }

    protected abstract void done();

    protected abstract long run();

    protected void print(Number n) {
        System.out.println("RESULT: "+ n);
    }
}

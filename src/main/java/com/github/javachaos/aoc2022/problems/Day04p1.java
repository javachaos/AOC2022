package com.github.javachaos.aoc2022.problems;


import java.util.concurrent.atomic.AtomicInteger;

public final class Day04p1 extends Problem {

    public Day04p1() {
        super("--- Day 4:1 Camp Cleanup ---");
    }

    @Override
    protected void init() {
        loadInputData("day4_1_input.txt");
    }

    @Override
    protected void done() {
        //Unused
    }

    @Override
    protected String run() {
        AtomicInteger count = new AtomicInteger();
        inputData.forEach(s -> {
            String[] elves = s.split(",");
            String[] firstElf = elves[0].split("-");
            String[] secondElf = elves[1].split("-");

            int a = Integer.parseInt(firstElf[0]);
            int b = Integer.parseInt(firstElf[1]);
            int c = Integer.parseInt(secondElf[0]);
            int d = Integer.parseInt(secondElf[1]);

            if ((a <= c && b >= d) || (a >= c && b <= d)) {
                count.getAndIncrement();
            }
        });
        return "" + count.get();
    }
}

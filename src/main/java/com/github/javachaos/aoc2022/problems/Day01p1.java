package com.github.javachaos.aoc2022.problems;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public final class Day01p1 extends Problem {

    public Day01p1() {
        super("--- Day 1:1 Calorie Counting ---");
    }

    @Override
    public void init() {
        loadInputData("day1_1_input.txt");
    }

    @Override
    protected void done() {
        //Unused
    }

    @Override
    public String run() {
        ArrayList<Integer> ints = new ArrayList<>();
        AtomicLong max = new AtomicLong();
        inputData.forEach(x -> {
            long currentSum;
            if (x.isBlank()) {
                currentSum = ints.stream().mapToInt(Integer::intValue).sum();
                if (currentSum > max.get()) {
                    max.set(currentSum);
                }
                ints.clear();
            } else {
                ints.add(Integer.parseInt(x));
            }
        });
        return "" + max.get();
    }

}

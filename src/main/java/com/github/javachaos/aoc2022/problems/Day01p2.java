package com.github.javachaos.aoc2022.problems;

import java.util.ArrayList;
import java.util.Collections;

public final class Day01p2 extends Problem {

    private ArrayList<Integer> sums;

    public Day01p2() {
        super("--- Day 1:2 Calorie Counting ---");
    }

    @Override
    public void init() {
        loadInputData("day1_2_input.txt");
        sums = new ArrayList<>();
    }

    @Override
    protected void done() {
        //Unused
    }

    @Override
    public String run() {
        ArrayList<Integer> ints = new ArrayList<>();
        inputData.forEach(x -> {
            long currentSum;
            if (x.isBlank()) {
                currentSum = ints.stream().mapToInt(Integer::intValue).sum();
                sums.add((int)currentSum);
                ints.clear();
            } else {
                int n = Integer.parseInt(x);
                ints.add(n);
                sums.add(n);
            }
        });
        return "" + sums.stream()          // get a stream
        .sorted(Collections.reverseOrder())// sort desc.
        .mapToInt(Integer::intValue)       // get In
        .limit(3)                 // limit to top 3
        .sum();                            // calc the sum.
    }
}

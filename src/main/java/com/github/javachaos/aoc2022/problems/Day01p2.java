package com.github.javachaos.aoc2022.problems;

import com.github.javachaos.aoc2022.utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day01p2 extends Problem {
    
    private Stream<String> inputData;
    private ArrayList<Integer> sums;
    private int i = 0;

    public Day01p2() {
        super("--- Day 1:2 Calorie Counting ---");
    }

    @Override
    public void init() {
        try {
            inputData = FileUtils.lines(FileUtils.getFileFromResource("day1_2_input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sums = new ArrayList<>();
    }

    @Override
    protected void done() {
        inputData.close();
    }

    @Override
    public long run() {
        ArrayList<Integer> ints = new ArrayList<>();
        AtomicLong max = new AtomicLong();
        inputData.forEach(x -> {
            long currentSum;
            if (x.isBlank()) {
                currentSum = ints.stream().mapToInt(Integer::intValue).sum();
                if (currentSum > max.get()) {
                    max.set(currentSum);
                }
                sums.add((int)currentSum);
                ints.clear();
            } else {
                int n = Integer.parseInt(x);
                ints.add(n);
                sums.add(n);
            }
        });
        return sums.stream()               // get a stream
        .sorted(Collections.reverseOrder())// sort desc.
        .mapToInt(Integer::intValue)       // get IntStream
        .limit(3)                          // limit to top 3
        .sum();                            // calc the sum.
    }
}

package com.github.javachaos.aoc2022.problems;

import java.util.List;

public class Day03p2 extends Problem {

    public Day03p2() {
        super("--- Day 3:2 Rucksack Reorganization ---");
    }

    @Override
    protected void init() {
        loadInputData("day3_1_input.txt");
    }

    @Override
    protected void done() {
        //Unused
    }

    @Override
    protected long run() {
        long result = 0;
        List<String> strings = inputData.toList();
        for (int i = 0; i < 100; i++) {
            String one =    strings.get(3 * i);
            String two =    strings.get(3 * i + 1);
            String three =  strings.get(3 * i + 2);
            char[] oS = one.toCharArray();
            char[] tS = two.toCharArray();
            char[] thS = three.toCharArray();
            char matching = 255;
            for (char c : oS) {
                for (char ch : tS) {
                    for (char chh : thS) {
                        if (c == ch && c == chh) {
                            matching = c;
                            break;
                        }
                    }
                }
            }
            result += convertToPriority(matching);
        }
        return result;
    }

    private int convertToPriority(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 27;
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 1;
        }
        return 0;
    }
}

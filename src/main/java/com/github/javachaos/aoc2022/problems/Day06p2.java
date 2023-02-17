package com.github.javachaos.aoc2022.problems;

import java.util.Optional;

//https://adventofcode.com/2022/day/6#part2
public class Day06p2 extends Day06p1 {

    private static final int WINDOW_SIZE = 14;

    public Day06p2() {
        super();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public String run() {
        Optional<String> line = inputData.findFirst();
        int tally = WINDOW_SIZE;
        final char[] window = new char[WINDOW_SIZE];
        char[] chars = null;
        if(line.isPresent()) {
            chars = line.get().toCharArray();
        }
        if (chars == null) {
            return "";
        }
        for (int i = WINDOW_SIZE - 1; i < chars.length; i++) {
            System.arraycopy(chars, i - WINDOW_SIZE + 1, window, 0, window.length);
            if (!isDistinct(window)) {
                tally++;
            } else {
                break;
            }
        }

        return "" + (tally);
    }

    private boolean isDistinct(final char[] window) {
        for (int i = 0; i < window.length; i++) {
            for (int j = 0; j < window.length; j++) {
                if (i != j && window[i] == window[j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
}

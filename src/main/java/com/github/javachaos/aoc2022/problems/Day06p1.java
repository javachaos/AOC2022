package com.github.javachaos.aoc2022.problems;

import java.util.Optional;

//https://adventofcode.com/2022/day/6
public class Day06p1 extends Problem {

    public Day06p1() {
        super("--- Day 6: Tuning Trouble ---");
    }

    @Override
    protected void init() {
        loadInputData("day6_1_input.txt");
    }

    @Override
    protected void done() {
      //Unused
    }

    @Override
    protected String run() {
        Optional<String> line = inputData.findFirst();
        int tally = 0;
        if(line.isPresent()) {
            char[] chars = line.get().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char current = chars[i];
                if (i >= 3) {
                    if (current == chars[i - 3] 
                    || current == chars[i - 2] 
                    || current == chars[i - 1]
                    || chars[i - 3] == chars[i - 2] 
                    || chars[i - 3] == chars[i - 1]
                    || chars[i - 2] == chars[i - 1]) {
                        tally++;
                    } else {
                        break;
                    }
                }
            }
        }

        return "" + (tally + 4);
        //That's the right answer! You are one gold star closer to collecting enough star fruit.
    }
    
}

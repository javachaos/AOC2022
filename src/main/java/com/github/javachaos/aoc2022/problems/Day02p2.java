package com.github.javachaos.aoc2022.problems;

import java.util.concurrent.atomic.AtomicLong;

public class Day02p2 extends Problem {

    /**
     * --- Part Two ---
     *
     * The Elf finishes helping with the tent and sneaks back over to you.
     * "Anyway, the second column says how the round needs to end: X means you need to lose,
     * Y means you need to end the round in a draw, and Z means you need to win. Good luck!"
     *
     * The total score is still calculated in the same way, but now you need to figure out what
     * shape to choose so the round ends as indicated. The example above now goes like this:
     *
     *     In the first round, your opponent will choose Rock (A), and you need the round to
     *     end in a draw (Y), so you also choose Rock. This gives you a score of 1 + 3 = 4.
     *     In the second round, your opponent will choose Paper (B), and you choose Rock so
     *     you lose (X) with a score of 1 + 0 = 1.
     *     In the third round, you will defeat your opponent's Scissors with Rock for a score of 1 + 6 = 7.
     *
     * Now that you're correctly decrypting the ultra top secret strategy guide, you would get a total score of 12.
     *
     * Following the Elf's instructions for the second column, what would your total score be
     * if everything goes exactly according to your strategy guide?
     */

    public Day02p2() {
        super("--- Day 2:2 Rock Paper Scissors ---");
    }

    @Override
    protected void init() {
        loadInputData("day2_1_input.txt");
    }

    @Override
    protected void done() {

    }

    //ROCK = 1
    //PAPER = 2
    //SCISSORS = 3
    @Override
    protected long run() {
        AtomicLong result = new AtomicLong(0);
        inputData.forEachOrdered(s -> {
            long score = 0;
            boolean isWin = false;
            char[] c = s.toCharArray();
            switch (c[0]) {
                case 'A' -> {//ROCK
                    switch (c[2]) {
                        case 'X' -> {// LOSS
                            score += 3;//SCISSORS
                        }
                        case 'Y' -> {// DRAW
                            score += 4;//ROCK
                        }
                        case 'Z' -> {// WIN
                            score = 8;//PAPER
                        }
                    }
                }
                case 'B' -> {//PAPER
                    switch (c[2]) {
                        case 'X' -> {// LOSS
                            score += 1;//ROCK
                        }
                        case 'Y' -> {// DRAW
                            score += 5;//PAPER
                        }
                        case 'Z' -> {// WIN
                            score += 9;//SCISSORS
                        }
                    }
                }
                case 'C' -> {//SCISSORS
                    switch (c[2]) {
                        case 'X' -> {// LOSS
                            score += 2;//PAPER
                        }
                        case 'Y' -> {// DRAW
                            score += 6;//SCISSORS
                        }
                        case 'Z' -> {// WIN
                            score += 7;//ROCK
                        }
                    }
                }
            }

            result.getAndAdd(score);
        });
        return result.get();
    }
}

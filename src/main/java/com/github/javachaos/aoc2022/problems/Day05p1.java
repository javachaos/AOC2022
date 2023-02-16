package com.github.javachaos.aoc2022.problems;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.regex.Pattern;

public sealed class Day05p1 extends Problem permits Day05p2 {

    protected ArrayDeque<String> stack1;
    protected ArrayDeque<String> stack2;
    protected ArrayDeque<String> stack3;
    protected ArrayDeque<String> stack4;
    protected ArrayDeque<String> stack5;
    protected ArrayDeque<String> stack6;
    protected ArrayDeque<String> stack7;
    protected ArrayDeque<String> stack8;
    protected ArrayDeque<String> stack9;
    protected ArrayDeque<String> tempQueue;
    protected ArrayList<ArrayDeque<String>> stacks;
    public Day05p1() {
        super("--- Day 5:1 Supply Stacks ---");
    }

    @Override
    protected void init() {
        loadInputData("day5_1_input.txt");
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
        stack3 = new ArrayDeque<>();
        stack4 = new ArrayDeque<>();
        stack5 = new ArrayDeque<>();
        stack6 = new ArrayDeque<>();
        stack7 = new ArrayDeque<>();
        stack8 = new ArrayDeque<>();
        stack9 = new ArrayDeque<>();
        tempQueue = new ArrayDeque<>();
        stacks = new ArrayList<>();
        //[F]         [L]     [M]
        //[T]     [H] [V] [G] [V]
        //[N]     [T] [D] [R] [N]     [D]
        //[Z]     [B] [C] [P] [B] [R] [Z]
        //[M]     [J] [N] [M] [F] [M] [V] [H]
        //[G] [J] [L] [J] [S] [C] [G] [M] [F]
        //[H] [W] [V] [P] [W] [H] [H] [N] [N]
        //[J] [V] [G] [B] [F] [G] [D] [H] [G]
        // 1   2   3   4   5   6   7   8   9
        stacks.add(stack1);
        stacks.add(stack2);
        stacks.add(stack3);
        stacks.add(stack4);
        stacks.add(stack5);
        stacks.add(stack6);
        stacks.add(stack7);
        stacks.add(stack8);
        stacks.add(stack9);

        stack1.push("J");
        stack1.push("H");
        stack1.push("G");
        stack1.push("M");
        stack1.push("Z");
        stack1.push("N");
        stack1.push("T");
        stack1.push("F");

        stack2.push("V");
        stack2.push("W");
        stack2.push("J");

        stack3.push("G");
        stack3.push("V");
        stack3.push("L");
        stack3.push("J");
        stack3.push("B");
        stack3.push("T");
        stack3.push("H");

        stack4.push("B");
        stack4.push("P");
        stack4.push("J");
        stack4.push("N");
        stack4.push("C");
        stack4.push("D");
        stack4.push("V");
        stack4.push("L");

        stack5.push("F");
        stack5.push("W");
        stack5.push("S");
        stack5.push("M");
        stack5.push("P");
        stack5.push("R");
        stack5.push("G");

        stack6.push("G");
        stack6.push("H");
        stack6.push("C");
        stack6.push("F");
        stack6.push("B");
        stack6.push("N");
        stack6.push("V");
        stack6.push("M");

        stack7.push("D");
        stack7.push("H");
        stack7.push("G");
        stack7.push("M");
        stack7.push("R");

        stack8.push("H");
        stack8.push("H");
        stack8.push("H");
        stack8.push("H");
        stack8.push("H");
        stack8.push("H");
        stack8.push("H");
        stack8.push("H");
        stack8.push("H");

        stack9.push("G");
        stack9.push("N");
        stack9.push("F");
        stack9.push("H");
    }

    @Override
    protected void done() {
        //Unused
    }

    protected void prettyPrint(ArrayList<ArrayDeque<String>> stacks) {
        logger.log(stacks.toString());
    }

    @Override
    protected String run() {
        // Precompile regular expression here for extra speed during runtime.
        Pattern p = Pattern.compile("move \\d+ from \\d+ to \\d+"); //move X from Y to Z
        inputData.forEach(s -> {
            if (p.matcher(s).matches()) {
                String[] tokens = s.split(" ");
                int x = Integer.parseInt(tokens[1]);
                int y = Integer.parseInt(tokens[3]);
                int z = Integer.parseInt(tokens[5]);
                int i = 0;
                while (!stacks.get(y - 1).isEmpty() && i++ < x) {
                    stacks.get(z - 1).push(stacks.get(y - 1).pop());
                }
            }
        });
        prettyPrint(stacks);
        StringBuilder result = new StringBuilder();
        for (ArrayDeque<String> d : stacks) {//Get the top of each stack and append it to the result.
            result.append(d.peek());
        }
        return result.toString();
    }
}

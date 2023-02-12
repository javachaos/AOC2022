package com.github.javachaos.aoc2022.problems;


import java.util.ArrayDeque;
import java.util.regex.Pattern;

public class Day05p2 extends Day05p1 {


    /**
     * --- Part Two ---
     * As you watch the crane operator expertly rearrange the crates, you notice the process isn't following your prediction.
     * Some mud was covering the writing on the side of the crane, and you quickly wipe it away.
     * The crane isn't a CrateMover 9000 - it's a CrateMover 9001.
     * The CrateMover 9001 is notable for many new and exciting features: air conditioning,
     * leather seats, an extra cup holder, and the ability to pick up and move multiple crates at once.
     * Again considering the example above, the crates begin in the same configuration:
     *     [D]
     * [N] [C]
     * [Z] [M] [P]
     *  1   2   3
     * Moving a single crate from stack 2 to stack 1 behaves the same as before:
     * [D]
     * [N] [C]
     * [Z] [M] [P]
     *  1   2   3
     * However, the action of moving three crates from stack 1 to stack 3 means that those three moved crates
     * stay in the same order, resulting in this new configuration:
     *         [D]
     *         [N]
     *     [C] [Z]
     *     [M] [P]
     *  1   2   3
     * Next, as both crates are moved from stack 2 to stack 1, they retain their order as well:
     *         [D]
     *         [N]
     * [C]     [Z]
     * [M]     [P]
     *  1   2   3
     * Finally, a single crate is still moved from stack 1 to stack 2, but now it's crate C that gets moved:
     *         [D]
     *         [N]
     *         [Z]
     * [M] [C] [P]
     *  1   2   3
     * In this example, the CrateMover 9001 has put the crates in a totally different order: MCD.
     * Before the rearrangement process finishes, update your simulation so that the Elves know where they should
     * stand to be ready to unload the final supplies. After the rearrangement procedure completes,
     * what crate ends up on top of each stack?
     */

    public Day05p2() {
        super();
    }

    @Override
    protected void done() {
        //Unused
    }

    @Override
    protected long run() {
        // Precompile regular expression here for extra speed during runtime.
        Pattern p = Pattern.compile("move \\d+ from \\d+ to \\d+"); //move X from Y to Z
        inputData.forEach(s -> {
            if (p.matcher(s).matches()) {
                String[] tokens = s.split(" ");
                int x = Integer.parseInt(tokens[1]);
                int y = Integer.parseInt(tokens[3]);
                int z = Integer.parseInt(tokens[5]);
                int i = 0;
                if (x == 1 && !stacks.get(y - 1).isEmpty()) {
                    stacks.get(z - 1).push(stacks.get(y - 1).pop());
                } else {
                    ArrayDeque<String> tempQueue = new ArrayDeque<>();
                    while (!stacks.get(y - 1).isEmpty() && i++ < x) {
                        tempQueue.offer(stacks.get(y - 1).pop());
                    }
                    while (!tempQueue.isEmpty()) {
                        stacks.get(z - 1).push(tempQueue.removeLast());
                    }
                }
            }
        });
        prettyPrint(stacks);
        StringBuilder result = new StringBuilder();
        for (ArrayDeque<String> d : stacks) {//Get the top of each stack and append it to the result.
            result.append(d.peek());
        }
        //That's the right answer! You are one gold star closer to collecting enough star fruit. Hurray!
        logger.log(result.toString());
        return 0;
    }
}

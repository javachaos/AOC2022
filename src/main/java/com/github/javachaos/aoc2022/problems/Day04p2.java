package com.github.javachaos.aoc2022.problems;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * --- Part Two ---
 *
 * It seems like there is still quite a bit of duplicate work planned.
 * Instead, the Elves would like to know the number of pairs that overlap at all.
 *
 * In the above example, the first two pairs (2-4,6-8 and 2-3,4-5) don't overlap,
 * while the remaining four pairs (5-7,7-9, 2-8,3-7, 6-6,4-6, and 2-6,4-8) do overlap:
 *
 *     5-7,7-9 overlaps in a single section, 7.
 *     2-8,3-7 overlaps all of the sections 3 through 7.
 *     6-6,4-6 overlaps in a single section, 6.
 *     2-6,4-8 overlaps in sections 4, 5, and 6.
 *
 * So, in this example, the number of overlapping assignment pairs is 4.
 *
 * In how many assignment pairs do the ranges overlap?
 */
public class Day04p2 extends Problem {

    public Day04p2() {
        super("--- Day 4:2 Camp Cleanup ---");
    }

    @Override
    protected void init() {
        loadInputData("day4_1_input.txt");
    }

    @Override
    protected void done() {
    }

    @Override
    protected long run() {

        //.234.....  2-4  false b < c
        //.....678.  6-8
        //
        //.23......  2-3 false b < c
        //...45....  4-5

        //.......89  8-9  !(b > c || b < c)
        //...45....  4-5 (b <= c && b >= c)

        //....567..  5-7 true
        //......789  7-9
        //
        //
        //.23456...  2-6 (a < c && b < d && b >= c)
        //...45678.  4-8

        //.....6789  6-9 (a > c && b > d && a <= d)
        //...4567..  4-7


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
                count.getAndIncrement(); //657
            }

            if ((a > c && b > d && a <= d) || (a < c && b < d && b >= c)) {
                count.getAndIncrement();
            }

        });
        return count.get();
    }
}

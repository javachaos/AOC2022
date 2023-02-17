package com.github.javachaos.aoc2022;

import com.github.javachaos.aoc2022.problems.*;
import com.github.javachaos.aoc2022.utils.FileLogger;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Test;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AOCTest {
    public static final FileLogger LOGGER = FileLogger.getLogger();

    @Timeout(value = 10, unit = SECONDS)
    @Test
    void test() {
        LOGGER.log("Starting problems!");
        //Add problem here
        LOGGER.log("Running problem: Day01 P1");
        Problem p = new Day01p1();
        assertEquals("69795", p.executeProblem());

        LOGGER.log("Running problem: Day01 P2");
        Problem p1 = new Day01p2();
        assertEquals("208437", p1.executeProblem());

        LOGGER.log("Running problem: Day02 P1");
        Problem p2 = new Day02p1();
        assertEquals("14531", p2.executeProblem());

        LOGGER.log("Running problem: Day02 P2");
        Problem p3 = new Day02p2();
        assertEquals("11258", p3.executeProblem());

        LOGGER.log("Running problem: Day03 P1");
        Problem p4 = new Day03p1();
        assertEquals("7795", p4.executeProblem());

        LOGGER.log("Running problem: Day03 P2");
        Problem p5 = new Day03p2();
        assertEquals("2703", p5.executeProblem());

        LOGGER.log("Running problem: Day04 P1");
        Problem p6 = new Day04p1();
        assertEquals("657", p6.executeProblem());

        LOGGER.log("Running problem: Day04 P2");
        Problem p7 = new Day04p2();
        assertEquals("938", p7.executeProblem());

        LOGGER.log("Running problem: Day05 P1");
        Problem p8 = new Day05p1();
        assertEquals("TDCHVHJTG", p8.executeProblem());

        LOGGER.log("Running problem: Day05 P2");
        Problem p9 = new Day05p2();
        assertEquals("NGCMPJLHV", p9.executeProblem());

        LOGGER.log("Running problem: Day06 P1");
        Problem p10 = new Day06p1();
        assertEquals("1109", p10.executeProblem());

        LOGGER.log("Running problem: Day06 P2");
        Problem p11 = new Day06p2();
        assertEquals("3965", p11.executeProblem());
    }
}

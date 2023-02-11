package com.github.javachaos.aoc2022;

import com.github.javachaos.aoc2022.problems.*;
import com.github.javachaos.aoc2022.utils.FileLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static final FileLogger LOGGER = FileLogger.getLogger();

    public static void main(String[] args) {

        LOGGER.log("Starting problems!");
        ArrayList<IProblem> problems = new ArrayList<>();

        //Add problem here
        LOGGER.log("Adding problems: Day01 P1");
        problems.add(new Day01p1());
        LOGGER.log("Adding problems: Day01 P2");
        problems.add(new Day01p2());
        LOGGER.log("Adding problems: Day02 P1");
        problems.add(new Day02p1());
        LOGGER.log("Adding problems: Day02 P2");
        problems.add(new Day02p2());
        LOGGER.log("Adding problems: Day03 P1");
        problems.add(new Day03p1());

        //RUN THROUGH ALL PROBLEMS AND EXECUTE THEM!!!
        problems.forEach(IProblem::executeProblem);

    }
}
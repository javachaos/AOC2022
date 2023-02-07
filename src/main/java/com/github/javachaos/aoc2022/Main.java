package com.github.javachaos.aoc2022;

import com.github.javachaos.aoc2022.problems.Day01p1;
import com.github.javachaos.aoc2022.problems.Day01p2;
import com.github.javachaos.aoc2022.problems.IProblem;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<IProblem> problems = new ArrayList<>();

        //Add problem here
        problems.add(new Day01p1());
        problems.add(new Day01p2());

        //RUN THROUGH ALL PROBLEMS AND EXECUTE THEM!!!
        problems.forEach(IProblem::executeProblem);

    }
}
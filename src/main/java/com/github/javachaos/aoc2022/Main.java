package com.github.javachaos.aoc2022;

import com.github.javachaos.aoc2022.problems.Day01p1;
import com.github.javachaos.aoc2022.problems.Day01p2;
import com.github.javachaos.aoc2022.problems.IProblem;
import com.github.javachaos.aoc2022.problems.Problem;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<IProblem> problems = new ArrayList<>();
        Problem d1 = new Day01p1();
        Problem d1_2 = new Day01p2();

        //Add problem here
        problems.add(d1);
        problems.add(d1_2);

        //RUN THROUGH ALL PROBLEMS AND EXECUTE THEM!!!
        problems.forEach(IProblem::executeProblem);

    }
}
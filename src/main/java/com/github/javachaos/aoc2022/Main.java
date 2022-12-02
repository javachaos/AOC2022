package com.github.javachaos.aoc2022;

import com.github.javachaos.aoc2022.problems.Day01;
import com.github.javachaos.aoc2022.problems.IProblem;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        ArrayList<IProblem> problems = new ArrayList<>();
        Day01 d1 = new Day01();

        //Add problem here
        problems.add(d1);

        //RUN THROUGH ALL PROBLEMS AND EXECUTE THEM!!!
        problems.forEach(IProblem::executeProblem);

    }
}
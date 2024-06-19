package org.example.twentytwo.one;

import java.io.FileNotFoundException;
import java.util.List;

public class ExerciseRunner {
    public static void main(String[] args) throws FileNotFoundException {
        List<Elf> elves = new ElfParser().parseCalorieFile("twentytwo/one/calories.txt");

        ElfCalorieFinder calorieFinder = new ElfCalorieFinder(elves);

        System.out.println("------ 2022 DAY 1 ------");
        System.out.println("Top elf: " + calorieFinder.getMostCalories(1));
        System.out.println("Top 3 elf: " + calorieFinder.getMostCalories(3));
    }
}

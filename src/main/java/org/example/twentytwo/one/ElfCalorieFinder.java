package org.example.twentytwo.one;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ElfCalorieFinder {
    List<Elf> elves;

    ElfCalorieFinder(List<Elf> elves) {
        this.elves = elves;
    }

    public Integer getMostCalories(int elfCount) {
        List<Elf> elvesByMaxCalories = new ArrayList<>(elves);
        elvesByMaxCalories.sort(Comparator.comparing(Elf::getTotalCalories));

        int totalElves = elvesByMaxCalories.size();
        List<Elf> topElves = elvesByMaxCalories.subList(totalElves - elfCount, totalElves);
        return sumTotalCalories(topElves);
    }

    private Integer sumTotalCalories(List<Elf> elves) {
        return elves.stream().mapToInt(Elf::getTotalCalories).sum();
    }
}

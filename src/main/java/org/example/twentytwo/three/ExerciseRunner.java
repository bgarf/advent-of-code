package org.example.twentytwo.three;
import org.example.twentytwo.utils.FileParser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseRunner {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> allRucksackItems = new FileParser().readFile("twentytwo/three/items.txt");
        List<Rucksack> rucksacks = allRucksackItems.stream()
                .map(Rucksack::new)
                .toList();

        int singleRucksackPriority = 0;
        int groupRucksackPriority = 0;

        for (Rucksack rucksack : rucksacks) {
            String commonItem = rucksack.findCommonItem();
            singleRucksackPriority += ItemPriority.getPriority(commonItem);
        }

        for (int i = 0; i < rucksacks.size(); i += 3) {
            List<Rucksack> rucksackGroup = rucksacks.subList(i, i + 3);
            ElfGroup elfGroup = new ElfGroup(rucksackGroup);
            String commonItem = elfGroup.getGroupBadge();

            groupRucksackPriority += ItemPriority.getPriority(commonItem);
        }

        System.out.println("part one: " + singleRucksackPriority);
        System.out.println("part two: " + groupRucksackPriority);
    }
}

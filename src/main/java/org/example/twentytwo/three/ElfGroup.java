package org.example.twentytwo.three;

import java.util.List;

public class ElfGroup {
    List<Rucksack> rucksacks;

    ElfGroup(List<Rucksack> rucksacks) {
        this.rucksacks = rucksacks;
    }

    public String getGroupBadge() {
        String[] firstRucksackItems = rucksacks.getFirst().getAllItems().split("");

        for (String item: firstRucksackItems) {
            if (rucksacks.get(1).contains(item) && rucksacks.get(2).contains(item)) {
                return item;
            }
        }

        return null;
    }
}

package org.example.twentytwo.three;

public class Rucksack {
    String compartmentOne;
    String compartmentTwo;

    final int DIVIDE_ITEMS_BY = 2;

    public Rucksack(String items) {
        int centre = items.length() / DIVIDE_ITEMS_BY;
        compartmentOne = items.substring(centre);
        compartmentTwo = items.substring(0, centre);
    }

    public String findCommonItem() {
        for (String item: compartmentOne.split("")) {
            if (compartmentTwo.contains(item)) {
                return item;
            }
        }
        return null;
    }

    public String getAllItems() {
        return getAllItems(compartmentOne, compartmentTwo);
    }

    public String getAllItems(String compartmentOne, String compartmentTwo) {
        return compartmentOne + compartmentTwo;
    }

    public boolean contains(String item) {
        return compartmentOne.contains(item) || compartmentTwo.contains(item);
    }
}

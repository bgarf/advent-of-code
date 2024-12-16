package org.example.twentytwo.one;

import org.example.twentytwo.utils.FileParser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ElfParser {
    public static final String EMPTY_LINE_DELIMITER = "\\n\\n+";

    public ArrayList<Elf> parseCalorieFile(String filePath) throws FileNotFoundException {
        ArrayList<Elf> elves = new ArrayList<>();
        FileParser fileParser = new FileParser();
        List<String> elfCalories = fileParser.readFile(filePath, EMPTY_LINE_DELIMITER);

        for(String elfCalorie: elfCalories) {
            Elf elf = new Elf(parseCaloriesFromString(elfCalorie));
            elves.add(elf);
        }

        return elves;
    }

    private ArrayList<Integer> parseCaloriesFromString(String calorieString) {
        ArrayList<Integer> calories = new ArrayList<>();
        for (String calorie: calorieString.split("\n")) {
            calories.add(Integer.valueOf(calorie));
        }
        return calories;
    }
}

package org.example.twentytwo.one;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ElfParser {
    public static final String EMPTY_LINE_DELIMITER = "\\n\\n+";

    public ArrayList<Elf> parseCalorieFile(String filePath) throws FileNotFoundException {
        InputStream io = getClass().getClassLoader().getResourceAsStream(filePath);

        if (io == null) {
            throw new FileNotFoundException("File path not found");
        }

        Scanner scanner = new Scanner(io).useDelimiter(EMPTY_LINE_DELIMITER);
        ArrayList<Elf> elves = new ArrayList<>();

        while (scanner.hasNext()) {
            String caloriesString = scanner.next();
            Elf elf = new Elf(parseCaloriesFromString(caloriesString));
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

package org.example.twentytwo.one;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ElfParser {

    public ArrayList<Elf> parseCalorieFile(String filePath) throws FileNotFoundException {
        InputStream io = getClass().getClassLoader().getResourceAsStream(filePath);

        if (io == null) {
            throw new FileNotFoundException("File path not found");
        }

        Scanner scanner = new Scanner(io).useDelimiter("\\n\\n+");
        ArrayList<Elf> elves = new ArrayList<>();

        while (scanner.hasNext()) {
            String caloriesString = scanner.next();
            Elf elf = new Elf(parseCalorieString(caloriesString));
            elves.add(elf);
        }

        return elves;
    }

    private ArrayList<Integer> parseCalorieString(String calorieString) {
        ArrayList<Integer> calories = new ArrayList<>();
        for (String calorie: calorieString.split("\n")) {
            calories.add(Integer.valueOf(calorie));
        }
        return calories;
    }
}

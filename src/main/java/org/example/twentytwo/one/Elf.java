package org.example.twentytwo.one;

import java.util.List;
import java.util.Objects;

public class Elf {
    private final List<Integer> calories;

    Elf(List<Integer> calories) {
        this.calories = calories;
    }

    public Integer getTotalCalories() {
        Integer total = 0;

        for (Integer calorie : calories) {
            total += calorie;
        }

        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elf elf = (Elf) o;
        return Objects.equals(calories, elf.calories);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(calories);
    }
}

package org.example.twentytwo.one;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CalorieReaderTest {
    @Test
    public void shouldReturnOneElfWithSingleCalorie() throws FileNotFoundException {
        String filePath = "twentytwo/one/single_calorie.txt";
        ArrayList<Elf> actual = new ElfParser().parseCalorieFile(filePath);

        assertThat(actual).containsExactly(new Elf(List.of(1234)));
    }

    @Test
    public void shouldReturnOneElfWithCalories() throws FileNotFoundException {
        String filePath = "twentytwo/one/multi_calorie.txt";
        ArrayList<Elf> actual = new ElfParser().parseCalorieFile(filePath);
        Elf elf = new Elf(List.of(1234, 5678));
        assertThat(actual).containsExactly(elf);
    }

    @Test
    public void shouldReturnMultipleElfWithCalories() throws FileNotFoundException {
        String filePath = "twentytwo/one/multi_elf.txt";
        ArrayList<Elf> actual = new ElfParser().parseCalorieFile(filePath);

        Elf firstElf = new Elf(List.of(1234, 5678));
        Elf secondElf = new Elf(List.of(9876));

        assertThat(actual).containsExactly(firstElf, secondElf);
    }

    @Test
    public void shouldReturnEmptyListWhenNoCalories() throws FileNotFoundException {
        String filePath = "twentytwo/one/empty.txt";
        ArrayList<Elf> actual = new ElfParser().parseCalorieFile(filePath);

        assertThat(actual).isEmpty();
    }

    @Test
    public void shouldThrowFileNotFoundWhenFilePathDoesntExist() {
        assertThatThrownBy(() -> {
            new ElfParser().parseCalorieFile("bad_path.txt");
        }).isInstanceOf(FileNotFoundException.class);
    }
}
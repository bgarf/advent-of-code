package org.example.twentytwo.one;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ElfCollectionTest {

    @Test
    public void shouldReturnMostCaloriesWhenOnlyOneElfInCollection() {
        Elf elf = new Elf(List.of(1234));
        ElfCalorieFinder elves = new ElfCalorieFinder(List.of(elf));

        Integer actual = elves.getMostCalories(1);

        assertThat(actual).isEqualTo(1234);
    }

    @Test
    public void shouldReturnTotalFromElfWithMostCalories() {
        Elf firstElf = new Elf(List.of(1234, 10000));
        Elf secondElf = new Elf(List.of(9876));
        ElfCalorieFinder elves = new ElfCalorieFinder(List.of(firstElf, secondElf));

        Integer actual = elves.getMostCalories(1);

        assertThat(actual).isEqualTo(11234);
    }

    @Test
    public void shouldReturnTotalFromTopThreeElvesWithMostCalories() {
        Elf firstElf = new Elf(List.of(5, 20));
        Elf secondElf = new Elf(List.of(10));
        Elf thirdElf = new Elf(List.of(30));
        Elf forthElf = new Elf(List.of(25));
        Elf fifthElf = new Elf(List.of(7));
        ElfCalorieFinder elves = new ElfCalorieFinder(List.of(firstElf, secondElf, thirdElf, forthElf, fifthElf));

        Integer actual = elves.getMostCalories(3);

        assertThat(actual).isEqualTo(80);
    }

//    public void shouldReturnEmptyListWhenNoElves() {
//        ElfCalorieFinder elves = new ElfCalorieFinder(List.of());
//        Elf actual = elves.getElfWithMostCalories();
//
//        assertThat(actual).isEmpty();
//    }

}
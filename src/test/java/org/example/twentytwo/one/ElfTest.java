package org.example.twentytwo.one;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ElfTest {

    @Test
    public void shouldReturnSumOfAllCalories() {
        Elf elf = new Elf(List.of(10, 15));

        Integer actual = elf.getTotalCalories();

        assertThat(actual).isEqualTo(25);
    }
}
package org.example.twentyfour.three;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerMemoryTest {
    @Test
    public void getMultipliersShouldParseSingleDigitMultiplier() {
        String input = "mul(1,2)";

        ComputerMemory computerMemory = new ComputerMemory(input);
        List<MultiplierPair> multipliers = computerMemory.getMultipliers();

        MultiplierPair expected = new MultiplierPair(1,2);

        assertEquals(1, multipliers.size());
        assertIterableEquals(List.of(expected), multipliers);
    }

    @Test
    public void getMultipliersShouldParseMultipleDigitMultiplier() {
        String input = "mul(134,256)";

        ComputerMemory computerMemory = new ComputerMemory(input);
        List<MultiplierPair> multipliers = computerMemory.getMultipliers();

        MultiplierPair expected = new MultiplierPair(134,256);

        assertEquals(1, multipliers.size());
        assertIterableEquals(List.of(expected), multipliers);
    }

    @Test
    public void getMultipliersShouldntParseIncompleteMultipleWithOneSide() {
        String input = "mul(4*";

        ComputerMemory computerMemory = new ComputerMemory(input);
        List<MultiplierPair> multipliers = computerMemory.getMultipliers();

        assertEquals(0, multipliers.size());
    }

    @Test
    public void getMultipliersShouldntParseIncompleteMultipleWithOneBracket() {
        String input = "mul(6,9!";

        ComputerMemory computerMemory = new ComputerMemory(input);
        List<MultiplierPair> multipliers = computerMemory.getMultipliers();

        assertEquals(0, multipliers.size());
    }

    @Test
    public void getMultipliersShouldntParseIncompleteMultipleWithNoMul() {
        String input = "?(12,34)";

        ComputerMemory computerMemory = new ComputerMemory(input);
        List<MultiplierPair> multipliers = computerMemory.getMultipliers();

        assertEquals(0, multipliers.size());
    }

    @Test
    public void getMultipliersShouldntParseMultipleSeperatedByWhitespace() {
        String input = "mul ( 2 , 4 )";

        ComputerMemory computerMemory = new ComputerMemory(input);
        List<MultiplierPair> multipliers = computerMemory.getMultipliers();

        assertEquals(0, multipliers.size());
    }

    @Test
    public void getMultipliersShouldParseMultiplesSeperatedByNoise() {
        String input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";

        ComputerMemory computerMemory = new ComputerMemory(input);
        List<MultiplierPair> multipliers = computerMemory.getMultipliers();

        assertEquals(4, multipliers.size());
    }

    @Test
    public void getAllowedMultipliersShouldParseAllSetsOFMultipliersThatArentProceededByDont() {
        String input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";

        ComputerMemory computerMemory = new ComputerMemory(input);
        List<MultiplierPair> multipliers = computerMemory.getAllowedMultipliers();

        MultiplierPair firstExpected = new MultiplierPair(2,4);
        MultiplierPair secondExpected = new MultiplierPair(8,5);

        assertEquals(2, multipliers.size());
        assertIterableEquals(List.of(firstExpected, secondExpected), multipliers);
    }


    @Test
    public void getAllowedMultipliersShouldParseAllAllowedMultipliers() {
        String input = "xmul(2,4)&mul(3,7)!^don't()_mul(5,5)";

        ComputerMemory computerMemory = new ComputerMemory(input);
        List<MultiplierPair> multipliers = computerMemory.getAllowedMultipliers();

        MultiplierPair firstExpected = new MultiplierPair(2,4);
        MultiplierPair secondExpected = new MultiplierPair(3,7);

        assertEquals(2, multipliers.size());
        assertIterableEquals(List.of(firstExpected, secondExpected), multipliers);
    }
}
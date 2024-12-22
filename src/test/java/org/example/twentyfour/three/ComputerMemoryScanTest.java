package org.example.twentyfour.three;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerMemoryScanTest {
    @Test
    public void shouldSumTheAllMultipliersInMemoryString() {
        String memory = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";

        Integer actual = ComputerMemoryScan.getTotalSumOfMultipliers(List.of(memory));

        assertEquals(161, actual);
    }

    @Test
    public void shouldSumTheAllMultipliersInMemoryStrings() {
        String memoryLineOne = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
        String memoryLineTwo = "xmul(4,5)%&mul[1,5]!@^do_not_mul(5,5)";

        Integer actual = ComputerMemoryScan.getTotalSumOfMultipliers(List.of(memoryLineOne, memoryLineTwo));

        assertEquals(206, actual);
    }

    @Test
    public void shouldScanWholeMemory() throws FileNotFoundException {
        String memoryPath = "twentyfour/three/memory.txt";

        Integer actual = ComputerMemoryScan.scanMemory(memoryPath);

        assertEquals(173731097, actual);
    }

    @Test
    public void shouldScanWholeAllowedMemory() throws FileNotFoundException {
        String memoryPath = "twentyfour/three/memory.txt";

        Integer actual = ComputerMemoryScan.scanAllowedMemory(memoryPath);

        assertEquals(93729253, actual);
    }
}
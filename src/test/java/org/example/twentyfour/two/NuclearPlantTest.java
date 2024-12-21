package org.example.twentyfour.two;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NuclearPlantTest {
    @Test
    public void getTotalSafeReportsAtPlantShouldReturnTotalFromInputData() throws FileNotFoundException {
        Integer actual = NuclearPlant.getTotalSafeReportsAtPlant("twentyfour/two/reports.txt");
        assertEquals(271, actual);
    }
}
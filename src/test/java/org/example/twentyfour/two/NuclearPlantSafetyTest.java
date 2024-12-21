package org.example.twentyfour.two;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NuclearPlantSafetyTest {
    @Test
    public void testGetTotalSafeReportsReturnsTotalFromInputData() {
        List<Report> reports = new ArrayList<>();
        reports.add(new Report("7 6 4 2 1"));
        reports.add(new Report("1 2 7 8 9"));
        reports.add(new Report("9 7 6 2 1"));
        reports.add(new Report("1 3 2 4 5"));
        reports.add(new Report("8 6 4 4 1"));
        reports.add(new Report("1 3 6 7 9"));

        NuclearPlantSafety plantSafety = new NuclearPlantSafety(reports);
        Integer actual = plantSafety.getTotalSafeReports();
        assertEquals(4, actual);
    }
}
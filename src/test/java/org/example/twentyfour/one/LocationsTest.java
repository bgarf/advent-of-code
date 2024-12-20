package org.example.twentyfour.one;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationsTest {

    @Test
    public void summaryShouldReturnAListOfSortedLocationsAtFirstPosition() {
        List<String> summaryInput = List.of("2   5", "3   6", "1   4");
        Locations summary = new Locations(summaryInput);

        List<Integer> actual = summary.getLocationOneIdsSorted();

        List<Integer> expected = List.of(1, 2, 3);

        assertEquals(expected, actual);
    }
    @Test
    public void summaryShouldReturnAListOfSortedLocationsAtSecondPosition() {
        List<String> summaryInput = List.of("2 5", "3 6", "1 4");
        Locations summary = new Locations(summaryInput);

        List<Integer> actual = summary.getLocationTwoIdsSorted();

        List<Integer> expected = List.of(4, 5, 6);

        assertEquals(expected, actual);
    }
}
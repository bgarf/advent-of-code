package org.example.twentyfour.one;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LocationFinderTest {
    @Test
    public void shouldReturnTotalDistanceFromInputData() throws FileNotFoundException {
        Integer actual = LocationFinder.getTotalDistanceBetweenSortedPoints("twentyfour/one/locations.txt");
        assertEquals(2344935, actual);
    }

    @Test
    public void shouldReturnTotalSimilarityScoreFromInputData() throws FileNotFoundException {
        Integer actual = LocationFinder.getSimilarityScoreForLocationIds("twentyfour/one/locations.txt");
        assertEquals(27647262, actual);
    }
}
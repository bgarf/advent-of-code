package org.example.twentyfour.one;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationDistanceTest {
    @Test
    public void shouldReturnTotalDistanceWhenLocationTwoPositionsAreGreaterThanLocationOne() {
        List<Integer> locationSetOne = List.of(2, 1, 3);
        List<Integer> locationSetTwo = List.of(7, 9, 3);
        LocationDistance locations = new LocationDistance(locationSetOne, locationSetTwo);

        Integer actual = locations.getTotalDistanceBetweenIds();

        assertEquals(13, actual);
    }

    @Test
    public void shouldReturnTotalDistanceWhenLocationTwoPositionsAreLessThanLocationOne() {
        List<Integer> locationSetOne = List.of(7, 9, 3);
        List<Integer> locationSetTwo = List.of(2, 1, 3);
        LocationDistance locations = new LocationDistance(locationSetOne, locationSetTwo);

        Integer actual = locations.getTotalDistanceBetweenIds();

        assertEquals(13, actual);
    }
}
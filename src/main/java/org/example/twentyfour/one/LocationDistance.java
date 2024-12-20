package org.example.twentyfour.one;

import java.util.List;
import java.util.stream.IntStream;

public class LocationDistance {
    private final List<Integer> positionOneIDs;
    private final List<Integer> positionTwoIDs;

    public LocationDistance(List<Integer> positionOneIDs, List<Integer> positionTwoIDs) {
        this.positionOneIDs = positionOneIDs;
        this.positionTwoIDs = positionTwoIDs;
    }

    public Integer getTotalDistanceBetweenIds() {
        return IntStream.range(0, positionOneIDs.size())
                .map(i -> Math.abs(positionOneIDs.get(i) - positionTwoIDs.get(i)))
                .sum();
    }
}

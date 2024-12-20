package org.example.twentyfour.one;

import org.example.utils.FileParser;

import java.io.FileNotFoundException;
import java.util.List;

public class LocationFinder {
    static Integer getTotalDistanceBetweenSortedPoints(String inputPath) throws FileNotFoundException {
        List<String> inputLocations = new FileParser().readFile(inputPath);
        Locations locations = new Locations(inputLocations);
        LocationDistance locationDistance = new LocationDistance(
                locations.getLocationOneIdsSorted(),
                locations.getLocationTwoIdsSorted()
        );
        return locationDistance.getTotalDistanceBetweenIds();
    }

    static Integer getSimilarityScoreForLocationIds(String inputPath) throws FileNotFoundException {
        List<String> inputLocations = new FileParser().readFile(inputPath);
        Locations locations = new Locations(inputLocations);
        IdSimilarity idSimilarity = new IdSimilarity(
                locations.getLocationOneIdsSorted(),
                locations.getLocationTwoIdsSorted()
        );
        return idSimilarity.calculateTotalSimilarityScore();
    }
}

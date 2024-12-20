package org.example.twentyfour.one;

import java.util.List;

public class IdSimilarity {
    private final List<Integer> locationIds;
    private final List<Integer> occurrences;

    public IdSimilarity(List<Integer> locationIds, List<Integer> occurrences) {
        this.locationIds = locationIds;
        this.occurrences = occurrences;
    }

    public Integer calculateTotalSimilarityScore() {
        return locationIds.stream()
                .map(this::calculateIdSimilarity)
                .reduce(0, Integer::sum);
    }

    private Integer calculateIdSimilarity(Integer id) {
        Integer totalOccurrences = occurrences.stream()
                .filter(occurrence -> occurrence.equals(id))
                .toList()
                .size();

        return totalOccurrences * id;
    }
}

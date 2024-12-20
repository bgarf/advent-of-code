package org.example.twentyfour.one;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IdSimilarityTest {
    @Test
    public void calculateTotalSimilarityScoreShouldReturnIDWhenSingleOccurrence() {
        List<Integer> ids = List.of(2);
        List<Integer> occurrences = List.of(2);
        IdSimilarity idSimilarity = new IdSimilarity(ids, occurrences);

        Integer actual = idSimilarity.calculateTotalSimilarityScore();

        assertEquals(actual, 2);
    }

    @Test
    public void calculateTotalSimilarityScoreShouldReturnZeroWhenIDHasNoOccurrences() {
        List<Integer> ids = List.of(2);
        List<Integer> occurrences = List.of(3);
        IdSimilarity idSimilarity = new IdSimilarity(ids, occurrences);

        Integer actual = idSimilarity.calculateTotalSimilarityScore();

        assertEquals(actual, 0);
    }

    @Test
    public void calculateTotalSimilarityScoreShouldReturnIDMultipliedByOccurrences() {
        List<Integer> ids = List.of(3);
        List<Integer> occurrences = List.of(3, 3, 3);
        IdSimilarity idSimilarity = new IdSimilarity(ids, occurrences);

        Integer actual = idSimilarity.calculateTotalSimilarityScore();

        assertEquals(actual, 9);
    }

    @Test
    public void calculateTotalSimilarityScoreShouldReturnAllIDOccurrences() {
        List<Integer> ids = List.of(4, 3, 2, 1);
        List<Integer> occurrences = List.of(1, 3, 2, 3, 3, 2);
        IdSimilarity idSimilarity = new IdSimilarity(ids, occurrences);

        Integer actual = idSimilarity.calculateTotalSimilarityScore();

        assertEquals(actual, 14);
    }
}
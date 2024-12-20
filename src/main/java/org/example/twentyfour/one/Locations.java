package org.example.twentyfour.one;
import java.util.List;

public class Locations {
    public static final String ID_DELIMITER = " {3}";
    private final List<String> lines;

    public Locations(List<String> lines) {
        this.lines = lines;
    }

    public List<Integer> getLocationOneIdsSorted() {
        return getSortedLocations(0);
    }

    public List<Integer> getLocationTwoIdsSorted() {
        return getSortedLocations(1);
    }

    private List<Integer> getSortedLocations(Integer index) {
        return lines.stream()
                .map(line -> line.split(ID_DELIMITER))
                .map(locations -> Integer.parseInt(locations[index]))
                .sorted()
                .toList();
    }
}

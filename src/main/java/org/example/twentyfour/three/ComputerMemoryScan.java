package org.example.twentyfour.three;

import org.example.utils.FileParser;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ComputerMemoryScan {
    public static Integer scanMemory(String memoryPath) throws FileNotFoundException {
        List<String> memory = new FileParser().readFile(memoryPath);
        return getTotalSumOfMultipliers(memory);
    }

    public static Integer scanAllowedMemory(String memoryPath) throws FileNotFoundException {
        List<String> memory = new FileParser().readFile(memoryPath);
        String memoryJoined = String.join("", memory);
        return getTotalSumOfMultipliers(getAllAllowedMultipliers(List.of(memoryJoined)));
    }

    public static Integer getTotalSumOfMultipliers(List<String> memory) {
        return getTotalSumOfMultipliers(getAllMultipliers(memory));
    }

    public static Integer getTotalSumOfMultipliers(Stream<List<MultiplierPair>> multipliers) {
        return multipliers
                .flatMap(List::stream)
                .mapToInt(MultiplierPair::getProduct)
                .sum();
    }

    private static Stream<List<MultiplierPair>> getAllMultipliers(List<String> memory) {
        return memory.stream()
                .map(ComputerMemory::new)
                .map(ComputerMemory::getMultipliers);
    }

    private static Stream<List<MultiplierPair>> getAllAllowedMultipliers(List<String> memory) {
        return memory.stream()
                .map(ComputerMemory::new)
                .map(ComputerMemory::getAllowedMultipliers);
    }
}

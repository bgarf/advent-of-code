package org.example.twentyfour.three;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComputerMemory {
    public static final String MULTIPLIER_PATTERN = "(mul\\((\\d*),(\\d*)\\))";
    public static final String DO_PATTERN = "((?=^|do\\(\\)).+?(?=do|$))";
    private final String memoryInput;


    public ComputerMemory(String memoryInput) {
        this.memoryInput = memoryInput;
    }

    public List<MultiplierPair> getAllowedMultipliers() {
        Pattern pattern = Pattern.compile(DO_PATTERN);
        Matcher matcher = pattern.matcher(memoryInput);
        List<MultiplierPair> multipliers = new ArrayList<>();

        while (matcher.find()) {
            multipliers.addAll(getMultipliers(matcher.group(1)));
        }

        return multipliers;
    }

    public List<MultiplierPair> getMultipliers() {
        return this.getMultipliers(memoryInput);
    }

    private List<MultiplierPair> getMultipliers(String input) {
        Pattern pattern = Pattern.compile(MULTIPLIER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        List<MultiplierPair> multipliers = new ArrayList<>();

        while (matcher.find()) {
            multipliers.add(
                    new MultiplierPair(
                            getMultipleFactor(matcher, 2),
                            getMultipleFactor(matcher, 3)
                    )
            );
        }

        return multipliers;
    }

    private static int getMultipleFactor(Matcher matcher, int group) {
        return Integer.parseInt(matcher.group(group));
    }
}

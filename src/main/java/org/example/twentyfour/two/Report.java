package org.example.twentyfour.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Integer.signum;
import static java.lang.Math.abs;

public class Report {
    List<Integer> levels;

    public Report (String levelsString) {
        levels = Arrays.stream(levelsString.split(" ")).map(Integer::parseInt).toList();
    }

    public boolean isSafe() {
        if (checkSafety(levels)) {
            return true;
        } else {
            List<Boolean> testedLevels = IntStream.range(0, levels.size()).mapToObj(index -> {
                List<Integer> newLevel = removeLevelFromLevels(index);
                return checkSafety(newLevel);
            }).filter(isSafe -> isSafe).toList();
            return !testedLevels.isEmpty();
        }
    }

    private List<Integer> removeLevelFromLevels(int index) {
        List<Integer> levelCopy = new ArrayList<>(levels);
        levelCopy.remove(index);
        return levelCopy;
    }

    private boolean checkSafety(List<Integer> levels) {
        int stepChange = 0;
        for (int i = 0; i < levels.size() - 1; i++) {
            int newStepChange = levels.get(i) - levels.get(i + 1);
            if (!isValidStepChange(newStepChange) || (!isSameStepDirection(stepChange, newStepChange) && i > 0)) {
                return false;
            } else {
                stepChange = newStepChange;
            }
        }
        return true;
    }

    private static boolean isValidStepChange(int newStepChange) {
        return newStepChange == 0 || abs(newStepChange) <= 3;
    }

    private static boolean isSameStepDirection(int stepChange, int newStepChange) {
        return signum(stepChange) == signum(newStepChange);
    }
}

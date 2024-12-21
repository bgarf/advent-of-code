package org.example.twentyfour.two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {
    @Test
    public void isSafeShouldReturnTrueForNumbersThatIncreaseByOne() {
        String levels = "1 2 3 4 5";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertTrue(actual);
    }

    @Test
    public void isSafeShouldReturnTrueForNumbersThatIncreaseByTwo() {
        String levels = "1 3 5 7 9";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertTrue(actual);
    }

    @Test
    public void isSafeShouldReturnTrueForNumbersThatIncreaseByThree() {
        String levels = "1 4 7 10 13";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertTrue(actual);
    }

    @Test
    public void isSafeShouldReturnTrueForNumbersThatIncreaseByDifferentLevels() {
        String levels = "1 3 6 7 9";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertTrue(actual);
    }

    @Test
    public void isSafeShouldReturnFalseForLevelsThatIncreaseByMoreThanThree() {
        String levels = "1 2 7 8 15";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertFalse(actual);
    }

    @Test
    public void isSafeShouldReturnTrueForNumbersThatDecreaseByOne() {
        String levels = "5 4 3 2 1";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertTrue(actual);
    }

    @Test
    public void isSafeShouldReturnTrueForNumbersThatDecreaseByTwo() {
        String levels = "9 7 5 3 1";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertTrue(actual);
    }

    @Test
    public void isSafeShouldReturnTrueForNumbersThatDecreaseByThree() {
        String levels = "13 10 7 4 1";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertTrue(actual);
    }

    @Test
    public void isSafeShouldReturnTrueForNumbersThatDecreaseByDifferentLevels() {
        String levels = "7 6 4 2 1";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertTrue(actual);
    }

    @Test
    public void isSafeShouldReturnFalseForLevelsThatDecreaseByMoreThanThree() {
        String levels = "15 7 6 2 1";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertFalse(actual);
    }

    @Test
    public void isSafeShouldReturnFalseForChangingLevelDirections() {
        String levels = "1 3 2 4 3";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertFalse(actual);
    }

    @Test
    public void isSafeShouldReturnFalseForNoChangingLevel() {
        String levels = "6 6 4 4 1";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertFalse(actual);
    }

    @Test
    public void isSafeShouldReturnTrueWhenOnlyOneLevelIsUnsafe() {
        String levels = "1 3 2 4 5";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertTrue(actual);
    }

    @Test
    public void isSafeShouldReturnFalse() {
        String levels = "9 7 6 2 1";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertFalse(actual);
    }

    @Test
    public void isSafeShouldReturnTrue() {
        String levels = "1 3 2 4 5";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertTrue(actual);
    }


    @Test
    public void isSafeShouldReturnTrueAfterRemovingLevelThatIsntFirstUnsafeLevel() {
        String levels = "1 5 2 3 4";
        Report report = new Report(levels);

        boolean actual = report.isSafe();

        assertTrue(actual);
    }
}
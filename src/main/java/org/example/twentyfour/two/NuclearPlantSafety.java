package org.example.twentyfour.two;

import java.util.List;

public class NuclearPlantSafety {
    private final List<Report> reports;

    public NuclearPlantSafety(List<Report> reports) {
        this.reports = reports;
    }

    public Integer getTotalSafeReports() {
        return reports.stream()
                .map(Report::isSafe)
                .filter(isSafe -> isSafe)
                .toList().size();
    }
}

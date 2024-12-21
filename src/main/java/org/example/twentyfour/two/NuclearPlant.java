package org.example.twentyfour.two;

import org.example.utils.FileParser;

import java.io.FileNotFoundException;
import java.util.List;

public class NuclearPlant {
    public static Integer getTotalSafeReportsAtPlant(String filePath) throws FileNotFoundException {
        List<String> inputReports = new FileParser().readFile(filePath);
        List<Report> reports = inputReports.stream().map(Report::new).toList();
        NuclearPlantSafety nuclearPlantSafety = new NuclearPlantSafety(reports);
        return nuclearPlantSafety.getTotalSafeReports();
    }
}

package org.example.twentytwo.utils;


import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {
    public List<String> readFile(String fileName) throws FileNotFoundException {
        return readFile(fileName, "");
    }

    public List<String> readFile(String fileName, String delimiter) throws FileNotFoundException {
        InputStream io = getClass().getClassLoader().getResourceAsStream(fileName);

        if (io == null) {
            throw new FileNotFoundException("File path not found");
        }

        Scanner scanner = new Scanner(io);

        if (!delimiter.isEmpty()) {
            scanner.useDelimiter(delimiter);
        }
        ArrayList<String> lines = new ArrayList<>();

        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }

        return lines;
    }
}

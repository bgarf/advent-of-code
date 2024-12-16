package org.example.twentytwo;

public class UnsupportedUserInputException extends Exception {
    UnsupportedUserInputException(String input) {
        super(String.format("Unsupported user input: %s", input));
    }
}

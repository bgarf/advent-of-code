package org.example.twentytwo.two;

import org.example.twentytwo.utils.FileParser;

import java.io.FileNotFoundException;
import java.util.List;

public class ExerciseRunner {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> rounds = new FileParser().readFile("twentytwo/two/games.txt");

        Game game = new Game(rounds);

        System.out.println("part one: " + game.playRounds());
        System.out.println("part two: " + game.playRoundsWithOutcomeKnow());
    }
}

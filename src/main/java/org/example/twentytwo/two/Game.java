package org.example.twentytwo.two;

import java.util.List;

public class Game {
    private final List<String> rounds;

    public Game(List<String> rounds) {
        this.rounds = rounds;
    }

    public int playRounds() {
        int gameTotal = 0;

        for (String round : rounds) {
            String[] hands = round.split(" ");
            Hand opponentHand = Hand.fromCode(hands[0].charAt(0));
            Hand playersHand = Hand.fromCode(hands[1].charAt(0));

            Round result = new Round(opponentHand, playersHand);

            gameTotal += result.calculateScore();
        }

        return gameTotal;
    }

    public int playRoundsWithOutcomeKnow() {
        int gameTotal = 0;

        for (String round : rounds) {
            String[] hands = round.split(" ");
            Hand opponentHand = Hand.fromCode(hands[0].charAt(0));
            Result outcome = Result.fromCode(hands[1].charAt(0));

            Round result = new Round(opponentHand, outcome);

            gameTotal += result.calculateScore();
        }

        return gameTotal;
    }

}

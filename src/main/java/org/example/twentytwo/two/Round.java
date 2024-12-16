package org.example.twentytwo.two;

import java.util.Map;

import static org.example.twentytwo.two.Hand.*;
import static org.example.twentytwo.two.Result.*;

public class Round {
    Hand opponentHand;
    Hand playersHand;
    Result gameResult;

    Map<Hand, Hand> winningOutcome = Map.of(SCISSOR, PAPER, PAPER, ROCK, ROCK, SCISSOR);
    Map<Hand, Hand> losingOutcome = Map.of(SCISSOR, ROCK, ROCK, PAPER, PAPER, SCISSOR);

    Round(Hand opponentHand, Hand playersHand) {
        this.opponentHand = opponentHand;
        this.playersHand = playersHand;
    }

    Round(Hand opponentHand, Result gameResult) {
        this.opponentHand = opponentHand;
        this.gameResult = gameResult;
    }

    public int calculateScore() {
        if (gameResult == null) {
            gameResult = decideOutcome();
        } else if (playersHand == null) {
            playersHand = decidePlayersHand();
        }

        return gameResult.getScorePoints() + playersHand.getScore();
    }

    private Result decideOutcome() {
        if (opponentHand == playersHand) {
            return DRAW;
        } else if (losingOutcome.get(opponentHand) == playersHand) {
            return WIN;
        } else {
            return LOSE;
        }
    }

    private Hand decidePlayersHand() {
        if (gameResult == DRAW) {
            return opponentHand;
        } else if (gameResult == WIN) {
            return losingOutcome.get(opponentHand);
        } else {
            return winningOutcome.get(opponentHand);
        }
    }
}

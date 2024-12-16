package org.example.twentytwo.two;

public enum Hand {
    ROCK(1),
    PAPER(2),
    SCISSOR(3);

    private final int score;

    Hand(int score) {
        this.score = score;
    }

    public static Hand fromCode(char code) {
        if (code == 'X' || code == 'A') {
            return ROCK;
        } else if (code == 'Y' || code == 'B') {
            return PAPER;
        } else if (code == 'Z' || code == 'C') {
            return SCISSOR;
        } else {
            throw new IllegalArgumentException("Invalid code: " + code);
        }
    }

    public int getScore() {
        return score;
    }
}

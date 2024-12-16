package org.example.twentytwo.two;

public enum Result {
    WIN(6),
    DRAW(3),
    LOSE(0);

    private final int scorePoints;

    Result(int scorePoints) {
        this.scorePoints = scorePoints;
    }

    public int getScorePoints() {
        return scorePoints;
    }

    public static Result fromCode(char code) {
        if (code == 'X') {
            return LOSE;
        } else if (code == 'Y') {
            return DRAW;
        } else if (code == 'Z') {
            return WIN;
        } else {
            throw new IllegalArgumentException("Invalid code: " + code);
        }
    }
}

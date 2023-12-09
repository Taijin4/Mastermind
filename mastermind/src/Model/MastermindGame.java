package Model;

import java.util.Random;

public class MastermindGame {
    private Combination secret;
    private Combination guess;
    private int roundScore;
    private int nbColor;

    public MastermindGame(int nbColor) {
        this.nbColor = nbColor;
    }

    public void setSecret(Combination secret) {
        this.secret = secret;
    }

    public void submitCombination(Combination guess) {
        this.guess = guess;
        Hint hint = new Hint().generateCombinationHint(this.guess, this.secret);

        System.out.println("Correct colors : " + hint.getCorrectColors());
        System.out.println("Correct positions : " + hint.getCorrectPositions());
    }

}

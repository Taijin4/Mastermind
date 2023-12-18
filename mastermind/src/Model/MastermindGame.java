package Model;

import java.util.List;
import java.util.Random;

public class MastermindGame {
    private Combination secret;
    private Combination guess;
    private int roundScore;
    private int nbRounds;
    private int nbColor;
    private int nbTrys;
    private List<MasterMindObserver> _observers;
    private int currentTry;

    public MastermindGame(int nbColor, int nbTrys) {
        this.nbColor = nbColor;
        this.nbTrys = nbTrys;
        currentTry = 0;
    }

    public void addObsever(MasterMindObserver observer) {
        _observers.add(observer);
    }

    public void startGame() {
        currentTry ++;
    }

    public void NextTurn() {
        if (currentTry <= nbTrys) {
            currentTry ++;
        }
    }

    public void setSecret(Combination secret) {
        this.secret = secret;
    }

    public void SubmitCombination(Combination guess) {
        this.guess = guess;
        Hint hint = new Hint().generateCombinationHint(this.guess, this.secret);

        System.out.println("Correct colors : " + hint.getCorrectColors());
        System.out.println("Correct positions : " + hint.getCorrectPositions());
    }

}

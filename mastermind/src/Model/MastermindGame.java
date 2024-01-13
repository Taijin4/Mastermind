package Model;

import java.util.ArrayList;
import java.util.List;

public class MastermindGame {
    private Combination secretCombination;
    private int nbRounds;
    private int nbColor;
    private int nbTrys;
    private int nbHoleCombination;
    private Combination playerCombination;
    private ShowHintStrategy hintStrategy;
    private int score = 0;
    private int actualTry = 1;
    private Hint lastHint = new Hint(0, 0);

    private List<MastermindGameObserver> observers;

    public MastermindGame(int nbColor, int nbRounds, int nbHoleCombination, int nbTrys) {
        this.nbColor = nbColor;
        this.nbRounds = nbRounds;
        this.nbHoleCombination = nbHoleCombination;
        this.playerCombination = new Combination(nbHoleCombination);
        this.nbTrys = nbTrys;
        this.hintStrategy = new ClassicHint();
        this.observers = new ArrayList<>();
    }

    public void setHintStrategy(ShowHintStrategy hintStrategy) {
        this.hintStrategy = hintStrategy;
    }
    public int getNbColor() {
        return this.nbColor;
    }

    public int getNbTrys() {
        return this.nbTrys;
    }

    public int getNbRounds() {
        return this.nbRounds;
    }

    public int getNbHoleCombination() {
        return this.nbHoleCombination;
    }

    public void addColorInCombination(Color color, int index) {
        playerCombination.setColorAtPosition(color, index);
    }

    public Combination getPlayerCombination() {
        return playerCombination;
    }

    public void setSecretCombination() {
        Combination secretCombination = new Combination(nbHoleCombination);
        secretCombination.generateSecretCombination(nbColor);
//        secretCombination.generateSecretCombinationOneTimeColor();
        this.secretCombination = secretCombination;
        secretCombination.printCombination();
    }


    public void addToScore(int roundScore) {
        this.score += roundScore;
    }

    public int getScore() {
        return this.score;
    }
    public int getActualTry() { return this.actualTry; }
    public void resetActualTry() {
        this.actualTry = 1;
    }

    public void submitTry() {
        Hint hint = hintStrategy.submitTry(playerCombination, secretCombination);
        for (MastermindGameObserver observer : observers) {
            observer.updateHint(hint);
        }
        actualTry ++;
        lastHint = hint;
        System.out.println("Submit");
    }

    public void addObserver(MastermindGameObserver observer) { observers.add(observer); }

    public Hint getLastHint() { return this.lastHint; }
    public ShowHintStrategy getHintStrategy() { return this.hintStrategy; }
    public void resetLastHint() {
        this.lastHint = new Hint(0, 0);
    }
}

package Model;

import java.util.List;

public class MastermindGame {
    private Combination secretCombination;
    private int nbRounds;
    private int nbColor;
    private int nbTrys;
    private int nbHoleCombination;
    private Combination playerCombination;
    private List<MasterMindObserver> _observers;
    private int score = 0;

    public MastermindGame(int nbColor, int nbRounds, int nbHoleCombination) {
        this.nbColor = nbColor;
        this.nbRounds = nbRounds;
        this.nbHoleCombination = nbHoleCombination;
        this.playerCombination = new Combination(nbHoleCombination);
    }

    public void addObsever(MasterMindObserver observer) {
        _observers.add(observer);
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
        secretCombination.generateSecretCombination();
//        secretCombination.generateSecretCombinationOneTimeColor();
        this.secretCombination = secretCombination;
        secretCombination.printCombination();
    }

    public Combination getSecretCombination() {
        return this.secretCombination;
    }

    public void addToScore(int roundScore) {
        this.score += roundScore;
    }

    public int getScore() {
        return this.score;
    }
}

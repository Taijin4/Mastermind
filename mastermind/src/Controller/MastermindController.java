package Controller;

import Model.Combination;
import Model.MastermindGame;

public class MastermindController {

    private MastermindGame model;
    // private MastermindView view;
    private int gameScore;
    private int nbColors;
    public MastermindController(MastermindGame model) {
        this.model = model;
        //this.view = view;
    }

    public void startGame(int nbRounds, int nbColors) {
        this.nbColors = nbColors;
        for (int i = 0; i < nbRounds; i++) {
            startRound(nbColors);
        }
    }

    public int startRound(int nbColors) {
        Combination testCombination = model.generateSecretCombination(nbColors);
        testCombination.printCombination();
        gameScore = model.getRoundScore() * nbColors;

        return gameScore;
    }

}

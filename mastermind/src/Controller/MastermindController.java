package Controller;

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

    public void startGame(int nbGames, int nbColors, int nbTrys) {
        for (int i = 0; i < nbGames; i++) {
            MastermindGame game = new MastermindGame(nbColors, nbTrys);
            game.startGame();
        }
    }

    public int startRound(int nbColors) {
//        Combination testCombination = model.generateSecretCombination();
//        testCombination.printCombination();
//        gameScore = model.getRoundScore() * nbColors;
//
        return gameScore;
    }

}

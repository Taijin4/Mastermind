package Controller;

import Model.Color;
import Model.Combination;
import Model.Hint;
import Model.MastermindGame;
import View.EndScreen;
import View.GameScreen;

public class MastermindController {

    private MastermindGame model;
    // private MastermindView view;
    private int gameScore;
    private int nbColors;
    private int actualRound = 1;
    public MastermindController(MastermindGame model) {
        this.model = model;
    }

    public void startGame() {
        if (actualRound <= model.getNbRounds()) {
            startRound(model.getNbColor(), 10, model.getNbHoleCombination());
            actualRound++;
        } else {
            endGame();
        }
    }

    public void endGame() {
        EndScreen endScreen = new EndScreen(model.getScore());
    }

    public int startRound(int nbColors, int nbTrys, int nbHoleCombination) {
        GameScreen gameScreen = new GameScreen(this, nbColors, nbTrys, nbHoleCombination);
        model.setSecretCombination();
        return 0;
    }

    public void endRound(int[] lastTurnHint) {
        int nbPiece = model.getNbHoleCombination();
        int nbWellPlacedPieces = lastTurnHint[0];

        int score = nbPiece - nbWellPlacedPieces;
        score += 3 * nbWellPlacedPieces;

        model.addToScore(score);
    }

    public void addColorInCombination(Color color, int index) {
        model.addColorInCombination(color, index);
    }

    public int[] submitTry() {
        if (model.getPlayerCombination().isValid()) {
            Combination playerCopy = new Combination(model.getPlayerCombination());
            model.getPlayerCombination().resetCombination();
            Hint hint = playerCopy.verifyCombination(model.getSecretCombination());
            int[] hintValues = new int[2];
            hintValues[0] = hint.getCorrectPositions();
            hintValues[1] = hint.getCorrectColors();
            return hintValues;
        }
        return new int[]{0};
    }

}

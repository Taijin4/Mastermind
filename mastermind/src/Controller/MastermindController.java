package Controller;

import Model.*;
import View.EndScreen;
import View.GameScreen;

public class MastermindController {

    private MastermindGame model;
    private int actualRound = 1;
    public MastermindController(MastermindGame model, int hintStrategy) {
        this.model = model;

        switch (hintStrategy) {
            case 0 -> model.setHintStrategy(new EasyHint());
            case 1 -> model.setHintStrategy(new ClassicHint());
            case 2 -> model.setHintStrategy(new DigitalHint());
        }

    }

    public void startGame() {
        if (actualRound <= model.getNbRounds()) {
            System.out.println("Actual round : " + actualRound + ", nbRounds : " + model.getNbRounds());
            startRound();
            actualRound++;
        } else {
            endGame();
        }
    }

    public void endGame() {

        if (model.getHintStrategy() instanceof ClassicHint) {
            EndScreen endScreen = new EndScreen(model.getScore() + 4);
        } else {
            EndScreen endScreen = new EndScreen(model.getScore());
        }

    }

    public int startRound() {
        GameScreen gameScreen = new GameScreen(this, this.model);
        model.resetLastHint();
        model.addObserver(gameScreen);
        model.setSecretCombination();
        model.resetActualTry();
        return 0;
    }

    public void endRound() {

        int nbWellPlacedPieces = model.getLastHint().getCorrectColorsAtCorrectPositions();
        int nbBadPlacedPieces = model.getLastHint().getCorrectColorsAtBadPositions();

        int score = nbBadPlacedPieces;
        score += 3 * nbWellPlacedPieces;

        model.addToScore(score);
        System.out.println("Add score : " + score);

        startGame();
    }

    public void addColorInCombination(Color color, int index) {
        model.addColorInCombination(color, index);
    }

    public void submitTry() {
        model.submitTry();
    }

    public boolean isRoundEnd() {
        Hint lastHint = model.getLastHint();
        boolean isEnd = false;

        if (lastHint.getCorrectColorsAtCorrectPositions() == model.getNbHoleCombination())
            isEnd = true;

        return isEnd;
    }


}

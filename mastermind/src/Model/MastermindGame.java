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
    public Combination generateSecretCombination(){
        Random random = new Random();
        Color couleurAleatoire;
        for(int i = 0; i < nbColor; i++) {
            couleurAleatoire = Color.values()[random.nextInt(Color.values().length)];
            secret.setColorAtPosition(couleurAleatoire, i);
        }
        return secret;
    }

    public Hint generateCombinationHint(){
        int correctColors=0;
        int correctPositions=0;

        Combination copyGuess = guess;

        for(int i = 0; i < copyGuess.size(); i++){
            if(secret.getColorAtPosition(i)==guess.getColorAtPosition(i)) {
                correctPositions++;
                copyGuess.removeAtPosition(i);
            }
        }
        for(int j = 0 ; j < copyGuess.size() ; j++){
            if(secret.containsColor(guess.getColorAtPosition(j))){
                correctColors++;
                //Potentiellement rajouter un remove si ca marche pas
            }
        }

        Hint hint = new Hint(correctPositions, correctColors);

        return hint;
    }

    public void submitCombination(Combination guess) {
        this.guess = guess;
    }


}

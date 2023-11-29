import java.util.Random;

public class MastermindModel {
    private Combination secret;
    private Combination guess;
    private int roundScore;

    public Combination generateSecretCombination(int nbColor){
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
        for(int i = 0; i < nbColor; i++){
            if(secret.getColorAtPosition(i)==guess.getColorAtPosition(i)){
                correctPositions++;
            }
            if(secret.get)
        }

        Hint hint = new Hint();

        return hint;
    }


}

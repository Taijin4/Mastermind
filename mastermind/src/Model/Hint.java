package Model;

public class Hint {
    private int correctPositions;
    private int correctColors;

    private Combination secret;
    
    public Hint(int positionCorrecte, int couleurCorrecte){
        this.correctPositions = positionCorrecte;
        this.correctColors = couleurCorrecte;
    }

    public int getCorrectPositions(){
        return this.correctPositions;
    }

    public int getCorrectColors(){
        return this.correctColors;
    }

    public Hint generateCombinationHint(int nbColor){
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

}

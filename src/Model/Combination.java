package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Combination {
    ArrayList<Color> colors;
    public Combination(int nbColors) {
        this.colors = new ArrayList<>(nbColors);
        for (int i = 0; i < nbColors; i++) {
            this.colors.add(Color.DEFAULT_COLOR); // Ajoutez ici vos couleurs par défaut
        }
    }

    public Combination(Combination combination) {
        this.colors = new ArrayList<>(combination.size());
        for (int i = 0; i < combination.size(); i++) {
            this.colors.add(combination.getColorAtPosition(i)); // Ajoutez ici vos couleurs par défaut
        }
    }

    public Color getColorAtPosition(int position) {
        return colors.get(position);
    }

    public void setColorAtPosition(Color color, int position) {
        colors.set(position, color);
    }


    public boolean containsColor(Color color){
        return colors.contains(color);
    }

    public int size() {
        return colors.size();
    }

    public void removeAtPosition(int i) {
        colors.remove(i);
    }
    public void replaceAtPosition(int i) {
        colors.set(i, Color.DEFAULT_COLOR);
    }

    public void removeColor(Color color) {
        this.colors.remove(color);
    }

    public void printCombination() {

        String answer = "";
        for (int i = 0; i < colors.size(); i++) {
            answer += colors.get(i) + " - ";
        }
    }

    public void generateSecretCombination(int nbColor){
        Random random = new Random();
        ArrayList<Color> tempColors = new ArrayList<>();
        Color couleurAleatoire;

        if (nbColor < this.colors.size()) {
            for(int i = 0; i < colors.size(); i++) {
                couleurAleatoire = Color.values()[random.nextInt(nbColor)];
                tempColors.add(couleurAleatoire);
            }
        } else {
            for(int i = 0; i < colors.size(); i++) {
                couleurAleatoire = Color.values()[random.nextInt(Color.values().length-1)];
                tempColors.add(couleurAleatoire);
            }
        }

        this.colors = tempColors;
    }

    public void generateSecretCombinationOneTimeColor(){
        Random random = new Random();
        ArrayList<Color> tempColors = new ArrayList<>();
        Color couleurAleatoire;
        for(int i = 0; i < colors.size(); i++) {
            couleurAleatoire = Color.values()[random.nextInt(Color.values().length-1)];
            while (tempColors.contains(couleurAleatoire))
                couleurAleatoire = Color.values()[random.nextInt(Color.values().length-1)];
            tempColors.add(couleurAleatoire);
        }
        this.colors = tempColors;
    }

    public boolean isValid() {
        boolean valid = true;
        for (Color color : colors) {
            if (color == Color.DEFAULT_COLOR)
                valid = false;
        }
        return valid;
    }

    public Hint verifyCombination(Combination secret){

        Hint hint = new Hint(secret.size());

        Combination copyGuess = this;
        Combination secretCopy = new Combination(secret);

        ArrayList<Integer> positionToRemove = new ArrayList<>(copyGuess.size());

        for(int i = 0; i < copyGuess.size(); i++){
            if(secretCopy.getColorAtPosition(i) == this.getColorAtPosition(i)) {
                hint.setValueAtPosition(HintSuccess.RightPositionColor, i);
                positionToRemove.add(i);
            }
        }

        Collections.sort(positionToRemove, Collections.reverseOrder());

        for (Integer i : positionToRemove) {
            copyGuess.replaceAtPosition(i);
            secretCopy.removeAtPosition(i);
        }


        for(int j = 0 ; j < copyGuess.size() ; j++){
            if(secretCopy.containsColor(this.getColorAtPosition(j))){
                hint.setValueAtPosition(HintSuccess.RightColor, j);
                secretCopy.removeColor(this.getColorAtPosition(j));
            }
        }


        return hint;
    }

    public void resetCombination() {
        for (int i = 0; i < this.colors.size(); i++) {
            this.colors.set(i, Color.DEFAULT_COLOR);
        }
    }
}
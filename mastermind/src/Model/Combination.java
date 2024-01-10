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

    public void addCombination(Color color) {
        colors.add(color);
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

    public void removeColor(Color color) {
        this.colors.remove(color);
    }

    public void printCombination() {

        String answer = "";
        for (int i = 0; i < colors.size(); i++) {
            answer += colors.get(i) + " - ";
        }
        System.out.println(answer);
    }

    public void generateSecretCombination(){
        Random random = new Random();
        ArrayList<Color> tempColors = new ArrayList<>();
        Color couleurAleatoire;
        for(int i = 0; i < colors.size(); i++) {
            couleurAleatoire = Color.values()[random.nextInt(Color.values().length-1)];
            tempColors.add(couleurAleatoire);
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
        int correctColors=0;
        int correctPositions=0;

        Combination copyGuess = this;
        Combination secretCopy = new Combination(secret);

        ArrayList<Integer> positionToRemove = new ArrayList<>(copyGuess.size());

        System.out.println();
        System.out.println("-------- Tour ----------");
        secretCopy.printCombination();
        this.printCombination();

        for(int i = 0; i < copyGuess.size(); i++){
            if(secretCopy.getColorAtPosition(i) == this.getColorAtPosition(i)) {
                System.out.println("Place identique : " + i + " => " + secretCopy.getColorAtPosition(i) + " = " + this.getColorAtPosition(i));
                correctPositions++;
                positionToRemove.add(i);
            }
        }

        Collections.sort(positionToRemove, Collections.reverseOrder());
        System.out.println();
        System.out.println("Position to remove : ");
        for (Integer i : positionToRemove) {
            System.out.println(i);
        }

        for (Integer i : positionToRemove) {
            copyGuess.removeAtPosition(i);
            secretCopy.removeAtPosition(i);
        }

        System.out.println();
        System.out.println("Nouvelle copy guess");
        copyGuess.printCombination();
        System.out.println();

        for(int j = 0 ; j < copyGuess.size() ; j++){
            if(secretCopy.containsColor(this.getColorAtPosition(j))){
                System.out.println("Secret contient la couleur : " + this.getColorAtPosition(j));
                correctColors++;
                secretCopy.removeColor(this.getColorAtPosition(j));
            }
        }
        System.out.println();
        System.out.println();

        Hint hint = new Hint(correctPositions, correctColors);

        return hint;
    }

    public void resetCombination() {
        for (int i = 0; i < this.colors.size(); i++) {
            this.colors.set(i, Color.DEFAULT_COLOR);
        }
    }
}
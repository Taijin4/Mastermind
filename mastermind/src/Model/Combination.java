package Model;

import java.util.ArrayList;
import java.util.Random;

public class Combination {


    ArrayList<Color> colors;

    public Combination(ArrayList<Color> couleurs) {
        this.colors = couleurs;
    }
    public Combination() {

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

    public void printCombination() {

        String answer = "";
        for (int i = 0; i < colors.size(); i++) {
            answer += colors.get(i) + " - ";
        }
        System.out.println(answer);
    }

    public void generateSecretCombination(int nbColor){
        Random random = new Random();
        ArrayList<Color> tempColors = new ArrayList<>();
        Color couleurAleatoire;
        for(int i = 0; i < nbColor; i++) {
            couleurAleatoire = Color.values()[random.nextInt(Color.values().length)];
            tempColors.add(couleurAleatoire);
        }
        this.colors = tempColors;
    }
}
package Model;

import java.util.ArrayList;

public class Hint {
    private int correctPositions;
    private int correctColors;
    private ArrayList<HintSuccess> hint = new ArrayList<>();

    
    public Hint(int correctPositions, int correctColors){
        this.correctPositions = correctPositions;
        this.correctColors = correctColors;
    }

    public Hint() {

    }

    public int getCorrectPositions(){
        return this.correctPositions;
    }

    public int getCorrectColors(){
        return this.correctColors;
    }

}

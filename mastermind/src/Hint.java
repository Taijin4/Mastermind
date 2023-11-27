public class Hint {
    private int correctPositions;
    private int correctColors;
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

}

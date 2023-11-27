public class Indice {
    private int positionCorrecte;
    private int couleurCorrecte;
    public Indice(int positionCorrecte, int couleurCorrecte){
        this.positionCorrecte = positionCorrecte;
        this.couleurCorrecte= couleurCorrecte;
    }

    public int getPositionCorrecte(){
        return this.positionCorrecte;
    }

    public int getCouleurCorrecte(){
        return this.couleurCorrecte;
    }

}

import java.util.ArrayList;

public class Combinaison {

    ArrayList<Couleur> couleurs;

    public Combinaison(ArrayList<Couleur> couleurs) {
        this.couleurs = couleurs;
    }

    public Couleur getCouleurALaPosition(int position) {
        return couleurs.get(position);
    }

}
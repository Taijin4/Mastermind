import java.util.ArrayList;

public class Combination {

    ArrayList<Color> colors;

    public Combination(ArrayList<Color> couleurs) {
        this.colors = couleurs;
    }

    public Color getColorAtPosition(int position) {
        return colors.get(position);
    }

}
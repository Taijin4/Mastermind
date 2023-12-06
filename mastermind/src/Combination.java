import java.util.ArrayList;

public class Combination {

    ArrayList<Color> colors;

    public Combination(ArrayList<Color> couleurs) {
        this.colors = couleurs;
    }

    public Color getColorAtPosition(int position) {
        return colors.get(position);
    }

    public void setColorAtPosition(Color color, int position) {
        colors.set(position, color);
    }

    public boolean hasColor(Combination secret, Color color) {
        if (colors.contains(color) && )
    }

    public int size() {
        return colors.size();
    }

    public void removeAtPosition(int i) {
        colors.remove(i);
    }

}
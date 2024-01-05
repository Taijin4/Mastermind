import Controller.MastermindController;
import Model.Color;
import Model.Combination;
import Model.Hint;
import Model.MastermindGame;
import View.EndScreen;
import View.GameScreen;
import View.StartScreen;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /*MastermindGame game = new MastermindGame(6, 10);
        Combination secret = new Combination();
        secret.generateSecretCombination(6);
        secret.printCombination();
        game.setSecret(secret);

        ArrayList<Color> playerColors = new ArrayList<>();
        playerColors.add(Color.GREEN);
        playerColors.add(Color.YELLOW);
        playerColors.add(Color.ORANGE);
        playerColors.add(Color.RED);
        playerColors.add(Color.PINK);
        playerColors.add(Color.GREEN);

        Combination joueur = new Combination(playerColors);
        joueur.printCombination();
        game.submitCombination(joueur);*/

        new StartScreen();
//        MastermindGame model = new MastermindGame(12, 6);
//        MastermindController controller = new MastermindController(model);
//        new GameScreen(controller, 6, 6, 12);
//            new EndScreen(5);
    }
}

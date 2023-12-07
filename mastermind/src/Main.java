import Model.Color;
import Model.Combination;
import Model.Hint;
import Model.MastermindGame;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MastermindGame model = new MastermindGame();
        Combination secret = Combination.generateSecretCombination(6);

        Combination gamer = new Combination(new ArrayList<>());
        model.submitCombination(gamer);
        Hint hint = Hint.generateCombinationHint(secret, gamer);
        Hint.showHint(hint);
    }
}
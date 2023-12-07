import Model.Combination;
import Model.Hint;
import Model.MastermindGame;

public class Main {

    public static void main(String[] args) {
        MastermindGame game = new MastermindGame(6);
        Combination secret =
        Combination gamer = new Combination(ArrayList< Color >())
        game.submitCombination(gamer);
        Hint hint = Hint.generateCombinationHint(secret, gamer);
        Hint.showHint(hint);
    }
}

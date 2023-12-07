public class Main {

    public static void main(String[] args) {
        MastermindGame model = new MastermindGame();
        Combination secret = Combination.generateSecretCombination(6);
        Combination gamer = new Combination(ArrayList<Color>())
        MastermindGame.submitCombination(gamer);
        Hint hint = Hint.generateCombinationHint(secret, gamer);
        Hint.showHint(hint);
    }
}

package Model;

public class EasyHint implements ShowHintStrategy{
	@Override
	public Hint submitTry(Combination playerCombination, Combination secretCombination) {
		Combination playerCopy = new Combination(playerCombination);
		playerCombination.resetCombination();
		Hint hint = playerCopy.verifyCombination(secretCombination);

		return hint;
	}
}

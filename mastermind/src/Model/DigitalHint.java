package Model;

public class DigitalHint implements ShowHintStrategy{
	@Override
	public Hint submitTry(Combination playerCombination, Combination secretCombination) {
		Combination playerCopy = new Combination(playerCombination);
		playerCombination.resetCombination();
		Hint hint = playerCopy.verifyCombination(secretCombination);

		int nbColorsWellPlaced = 0;
		int nbColorsBadPlaced = 0;

		for (int i = 0; i < hint.getSize(); i++) {
			if (hint.getValueAtPosition(i) == HintSuccess.RightPositionColor) {
				nbColorsWellPlaced ++;
			} else if (hint.getValueAtPosition(i) == HintSuccess.RightColor) {
				nbColorsBadPlaced ++;
			}
		}

		return new Hint(nbColorsWellPlaced, nbColorsBadPlaced);
	}
}

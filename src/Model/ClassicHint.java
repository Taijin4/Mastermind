package Model;

public class ClassicHint implements ShowHintStrategy{
	@Override
	public Hint submitTry(Combination playerCombination, Combination secretCombination) {
		Combination playerCopy = new Combination(playerCombination);
		playerCombination.resetCombination();
		Hint hint = playerCopy.verifyCombination(secretCombination);

		Hint hintOrdered = new Hint(hint.getSize());

		int j = 0;
		for (int i = 0; i < hint.getSize(); i++) {
			if (hint.getValueAtPosition(i) == HintSuccess.RightPositionColor) {
				hintOrdered.setValueAtPosition(HintSuccess.RightPositionColor, j);
				j++;
			}
		}

		for (int i = 0; i < hint.getSize(); i++) {
			if (hint.getValueAtPosition(i) == HintSuccess.RightColor) {
				hintOrdered.setValueAtPosition(HintSuccess.RightColor, j);
				j++;
			}
		}

		return hintOrdered;
	}
}

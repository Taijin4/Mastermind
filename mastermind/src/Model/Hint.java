package Model;

import java.util.ArrayList;

public class Hint {
    private ArrayList<HintSuccess> hint;
    private ArrayList<Integer> hintNumbers = new ArrayList<Integer>(2);
    private boolean hintSuccessArray = false;

    public Hint(int correctColorsAtCorrectPositions, int correctColorsAtBadPositions){
        hintNumbers.add(correctColorsAtCorrectPositions);
        hintNumbers.add(correctColorsAtBadPositions);
    }

    public Hint(int size) {
        this.hint = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.hint.add(i, HintSuccess.False);
        }
        hintSuccessArray = true;
    }

    public int getCorrectColorsAtCorrectPositions(){
        int val = 0;
        if (hintSuccessArray) {
            for (int i = 0; i < hint.size(); i++) {
                if (hint.get(i) == HintSuccess.RightPositionColor)
                    val ++;
            }
        } else {
            val = this.hintNumbers.get(0);
        }

        return val;
    }

    public int getCorrectColorsAtBadPositions(){
        int val = 0;
        if (hintSuccessArray) {
            for (int i = 0; i < hint.size(); i++) {
                if (hint.get(i) == HintSuccess.RightColor)
                    val ++;
            }
        } else {
            val = this.hintNumbers.get(1);
        }

        return val;
    }

    public void setValueAtPosition(HintSuccess value, int i) {
        hint.set(i, value);
    }

    public HintSuccess getValueAtPosition(int i) {
        return this.hint.get(i);
    }

    public int getSize() {
        return this.hint.size();
    }

    public void printHint() {
        String fi = "";
        for (int i = 0; i < this.hint.size(); i++) {
            fi += this.hint.get(i) + " - ";
        }
        System.out.println(fi);
    }

    public boolean isHintSuccessArray() {
        return hintSuccessArray;
    }

}

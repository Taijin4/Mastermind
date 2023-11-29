public class MastermindController {

    private MastermindModel model;
    // private MastermindView view;
    private int gameScore;
    private int nbColors;
    public MastermindController(MastermindModel model, MastermindView view) {
        this.model = model;
        //this.view = view;
    }

    public void startGame(int nbRounds, int nbColors) {
        this.nbColors = nbColors;
        for (int i = 0; i < nbRounds; i++) {
            startRound(nbColors);
        }
    }

    public int startRound(int nbColors) {


        return 0;
    }

}

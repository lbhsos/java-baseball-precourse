package baseball.domain;

import java.util.Map;

import static baseball.view.Message.*;

public class BaseballGame {

    private Computer computer;
    private Player player;
    private boolean correctAnswer = false;
    private boolean onGame = true;

    private static final int CONTINUE = 1;

    public boolean start() {
        this.computer = new Computer();
        this.player = new Player();

        while (!correctAnswer) {
            printInputRequired();
            Map<Integer, Integer> baseballInput = player.getBaseballInput();
            correctAnswer = isCorrectAnswer(baseballInput);
        }

        askContinueGame();
        int gameContinueInput = player.getGameContinueInput();
        boolean continueFlag = checkContinue(gameContinueInput);
        return continueFlag;
    }

    public void quit() {
        printGameEnd();
    }

    private boolean checkContinue(int userInput) {
        if (userInput == CONTINUE) {
            this.correctAnswer = false;
            return this.onGame;
        }
        return this.onGame = false;
    }

    private boolean isCorrectAnswer(Map<Integer, Integer> userBaseballInput) {
        boolean result = computer.compare(userBaseballInput);
        if (result) {
            printAppEnd();
        }
        return this.correctAnswer = result;
    }
}

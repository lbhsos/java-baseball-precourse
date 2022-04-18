package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;

import java.util.Map;

import static baseball.view.Message.*;

public class BaseballGame {

    private Computer computer;
    private Player player;
    private boolean correctAnswer = false;

    private static final int CONTINUE = 1;

    public boolean start() {
        this.computer = new Computer();
        this.player = new Player();
        this.correctAnswer = false;

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
        printAppEnd();
    }

    private boolean checkContinue(int userInput) {
        if (userInput == CONTINUE) {
            return true;
        }
        return false;
    }

    private boolean isCorrectAnswer(Map<Integer, Integer> userBaseballInput) {
        boolean answer = computer.compare(userBaseballInput);
        if (answer) {
            printGameEnd();
        }
        return this.correctAnswer = answer;
    }
}

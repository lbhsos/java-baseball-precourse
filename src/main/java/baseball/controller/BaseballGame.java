package baseball.controller;

import baseball.model.BaseballResult;
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
            play();
        }
        return askContinueGame();
    }

    public void quit() {
        printAppEnd();
    }

    private boolean askContinueGame() {
        printAskingContinueGame();
        int gameContinueInput = player.getGameContinueInput();
        boolean continueFlag = checkContinue(gameContinueInput);
        return continueFlag;
    }

    private void play() {
        printInputRequired();
        Map<Integer, Integer> baseballInput = player.getBaseballInput();
        BaseballResult baseballResult = getBaseballResult(baseballInput);
        correctAnswer = isCorrectAnswer(baseballResult);
    }

    private BaseballResult getBaseballResult(Map<Integer, Integer> userBaseballInput) {
        BaseballResult baseballResult = computer.compare(userBaseballInput);
        print(baseballResult.getResultText());
        return baseballResult;
    }

    private boolean isCorrectAnswer(BaseballResult baseballResult) {
        boolean answer = baseballResult.isAnswer();
        if (answer) {
            printGameEnd();
        }
        return this.correctAnswer = answer;
    }

    private boolean checkContinue(int userInput) {
        if (userInput == CONTINUE) {
            return true;
        }
        return false;
    }
}

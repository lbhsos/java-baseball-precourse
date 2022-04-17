package baseball.domain;

import java.util.Map;

public class BaseballGame {

    private Computer computer;
    private boolean correctAnswer = false;
    private boolean onGame = true;
    private static final int CONTINUE = 1;

    void start() {
        this.computer = new Computer();
    }

    //TODO userInput 받기전 value 검증 필요
    boolean continueGame(int userInput) {
        if (userInput == CONTINUE) {
            this.correctAnswer = false;
            return this.onGame;
        }
        return this.onGame = false;
    }

    boolean isCorrectAnswer(Map<Integer, Integer> userBaseballInput) {
        boolean result = computer.compare(userBaseballInput);
        return this.correctAnswer = result;
    }

    void exit() {
        // TODO
    }
}

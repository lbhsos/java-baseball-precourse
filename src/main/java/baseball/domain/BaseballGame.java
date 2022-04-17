package baseball.domain;

public class BaseballGame {

    private boolean correctAnswer = false;
    private boolean onGame = true;

    Computer start() {
        return new Computer();
    }

    boolean exit() {
        return this.onGame = false;
    }
}

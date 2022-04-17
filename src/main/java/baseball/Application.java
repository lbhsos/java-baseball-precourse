package baseball;

import baseball.domain.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        boolean onGame = true;
        while (onGame) {
            onGame = baseballGame.start();
        }
        baseballGame.quit();
    }
}

package baseball.domain;

import java.util.Map;

public class BaseballGame {

    private Computer computer;
    private Player player;
    private boolean correctAnswer = false;
    private boolean onGame = true;

    private static final int CONTINUE = 1;
    public static final String BASEBALL_INPUT_REQUIRED_MESSAGE = "숫자를 입력해주세요: ";
    public static final String GAME_CONTINUE_INPUT_REQUIRED_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public boolean start() {
        this.computer = new Computer();

        while (!correctAnswer) {
            System.out.print(BASEBALL_INPUT_REQUIRED_MESSAGE);
            Map<Integer, Integer> baseballInput = player.getBaseballInput();
            correctAnswer = isCorrectAnswer(baseballInput);
        }

        System.out.println(GAME_CONTINUE_INPUT_REQUIRED_MESSAGE);
        int gameContinueInput = player.getGameContinueInput();
        boolean continueFlag = checkContinue(gameContinueInput);
        return continueFlag;
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
            System.out.println(GAME_END_MESSAGE);
        }
        return this.correctAnswer = result;
    }
}

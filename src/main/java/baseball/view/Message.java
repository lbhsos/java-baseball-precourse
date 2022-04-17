package baseball.view;

import baseball.model.BaseballResult;

public class Message {
    public static final String BASEBALL_INPUT_REQUIRED_MESSAGE = "숫자를 입력해주세요: ";
    public static final String GAME_CONTINUE_INPUT_REQUIRED_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String END_MESSAGE = "게임 종료";
    public static final String INVALID_LENGTH_INPUT_MESSAGE = "1-9 사이의 서로 다른 임의의 수 '3개'를 입력하여주세요.";
    public static final String INVALID_VALUE_INPUT_MESSAGE = "숫자만 입력 가능합니다.";
    public static final String INVALID_VALUE_GAME_CONTINUE_INPUT_MESSAGE = "1 또는 2만 입력 가능합니다.";
    public static final String DIFFERENT_VALUE_REQUIRED_MESSAGE = "1-9 사이의 서로 '다른' 임의의 수 3개를 입력하여주세요.";
    public static final String INVALID_RANGE_INPUT_MESSAGE = "'1-9 사이'의 서로 다른 임의의 수 3개를 입력하여주세요.";

    public static void printInputRequired() {
        System.out.print(BASEBALL_INPUT_REQUIRED_MESSAGE);
    }
    public static void askContinueGame() {
        System.out.print(GAME_CONTINUE_INPUT_REQUIRED_MESSAGE);
    }
    public static void printGameEnd() {
        System.out.print(GAME_END_MESSAGE);
    }
    public static void printAppEnd() {
        System.out.print(END_MESSAGE);
    }
    public static void print(BaseballResult baseballResult) {
        String resultText = baseballResult.getResultText();
        System.out.println(resultText);
    }
}

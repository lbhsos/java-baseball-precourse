package baseball.domain;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {

    private static final int READ_ONLY_ONE = 0;
    private static final int GAME_INPUT_LENGTH = 1;
    private static final int BASEBALL_INPUT_LENGTH = 3;
    public static final String INVALID_LENGTH_INPUT_MESSAGE = "1-9 사이의 서로 다른 임의의 수 '3개'를 입력하여주세요.";
    public static final String INVALID_VALUE_INPUT_MESSAGE = "숫자만 입력 가능합니다.";
    public static final String INVALID_VALUE_GAME_CONTINUE_INPUT_MESSAGE = "1 또는 2만 입력 가능합니다.";
    public static final String DIFFERENT_VALUE_REQUIRED_MESSAGE = "1-9 사이의 서로 '다른' 임의의 수 3개를 입력하여주세요.";
    public static final String INVALID_RANGE_INPUT_MESSAGE = "'1-9 사이'의 서로 다른 임의의 수 3개를 입력하여주세요.";

    public Map<Integer, Integer> getBaseballInput() {
        String input = readLine();
        return stringToMap(input.trim());
    }

    public int getGameContinueInput() {
        String input = readLine();
        int inGameStatus = isInGameStatus(input.trim());
        return inGameStatus;
    }

    private int isInGameStatus(String input) {
        checkLength(input, GAME_INPUT_LENGTH);
        char userInput = input.charAt(READ_ONLY_ONE);
        isNumeric(input.charAt(READ_ONLY_ONE));
        int numericValue = Character.getNumericValue(userInput);
        if (numericValue != GameStatus.EXIT.getValue() && numericValue != GameStatus.CONTINUE.getValue()) {
            throw new IllegalArgumentException(INVALID_VALUE_GAME_CONTINUE_INPUT_MESSAGE);
        }
        return numericValue;
    }

    private Map<Integer, Integer> stringToMap(String numberAsText) {
        checkLength(numberAsText, BASEBALL_INPUT_LENGTH);
        Map<Integer, Integer> baseballNum = new HashMap<>();
        for (int i=0; i<BASEBALL_INPUT_LENGTH; i++) {
            char c = numberAsText.charAt(i);
            isNumeric(c);
            int numericValue = Character.getNumericValue(c);
            isInRange(numericValue);
            checkDuplicate(baseballNum, numericValue);
            baseballNum.put(numericValue, i);
        }
        return baseballNum;
    }

    private void isInRange(int numericValue) {
        if (numericValue == 0) {
            throw new IllegalArgumentException(INVALID_RANGE_INPUT_MESSAGE);
        }
    }

    private void checkDuplicate(Map<Integer, Integer> baseballNum, int numKey) {
        if (baseballNum.containsKey(numKey)) {
            throw new IllegalArgumentException(DIFFERENT_VALUE_REQUIRED_MESSAGE);
        }
    }

    private void checkLength(String numberAsText, int fixedLength ) {
        if (numberAsText.length() != fixedLength) {
            throw new IllegalArgumentException(INVALID_LENGTH_INPUT_MESSAGE);
        }
    }

    private void isNumeric(char charNumber) {
        if (!Character.isDigit(charNumber)) {
            throw new IllegalArgumentException(INVALID_VALUE_INPUT_MESSAGE);
        }
    }
}

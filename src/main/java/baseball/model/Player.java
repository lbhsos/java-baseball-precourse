package baseball.model;

import baseball.status.GameStatus;

import java.util.HashMap;
import java.util.Map;

import static baseball.view.Message.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {

    private static final int READ_ONLY_ONE = 0;
    private static final int GAME_INPUT_LENGTH = 1;
    private static final int BASEBALL_INPUT_LENGTH = 3;

    public Map<Integer, Integer> getBaseballInput() {
        String input = readLine().trim();
        checkLength(input, BASEBALL_INPUT_LENGTH);
        return stringToMap(input);
    }

    public int getGameContinueInput() {
        String input = readLine().trim();
        checkLength(input, GAME_INPUT_LENGTH);
        int inGameStatus = isInGameStatus(input);
        return inGameStatus;
    }

    private Map<Integer, Integer> stringToMap(String numberAsText) {
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

    private int isInGameStatus(String input) {
        char userInput = input.charAt(READ_ONLY_ONE);
        isNumeric(input.charAt(READ_ONLY_ONE));
        int numericValue = Character.getNumericValue(userInput);
        if (numericValue != GameStatus.EXIT.getValue() && numericValue != GameStatus.CONTINUE.getValue()) {
            throw new IllegalArgumentException(INVALID_VALUE_GAME_CONTINUE_INPUT_MESSAGE);
        }
        return numericValue;
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
}

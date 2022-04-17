package baseball.domain;

import baseball.status.ResultStatus;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Computer {
    // Map<number, position>
    private Map<Integer, Integer> baseballNum;

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int BASEBALL_NUM = 3;

    public Computer() {
        this.generator();
    }

    private void generator() {
        baseballNum = new HashMap<>();
        for (int seq = 0; seq<BASEBALL_NUM; seq++) {
            int randomNumber = getRandomNumber();
            baseballNum.put(randomNumber, seq);
        }
    }

    private int getRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        while (baseballNum.containsKey(randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        }
        return randomNumber;
    }

    boolean compare(Map<Integer, Integer> userBaseballInput) {
        int strikeCount = 0;
        int bollCount = 0;

        for (Integer userNumber : userBaseballInput.keySet()) {
            Integer userPosition = userBaseballInput.get(userNumber);
            ResultStatus result = match(userNumber, userPosition);
            strikeCount += strike(result);
            bollCount += boll(result);
        }
        BaseballResult baseballResult = new BaseballResult(strikeCount, bollCount);
        printResult(baseballResult);
        return baseballResult.isAnswer();
    }

    private void printResult(BaseballResult baseballResult){
        String resultText = baseballResult.getResultText();
        System.out.println(resultText);
    }

    private ResultStatus match(int userNumber, int userPosition) {
        if (!checkContains(userNumber)) {
            return ResultStatus.NOTHING;
        }
        Integer answerPosition = baseballNum.get(userNumber);
        if (answerPosition == userPosition) {
            return ResultStatus.STRIKE;
        }
        return ResultStatus.BOLL;
    }

    private boolean checkContains(int userNumber) {
        if (!baseballNum.containsKey(userNumber)) {
            return false;
        }
        return true;
    }

    private int strike(ResultStatus result) {
        if (result == ResultStatus.STRIKE) {
            return 1;
        }
        return 0;
    }

    private int boll(ResultStatus result) {
        if (result == ResultStatus.BOLL) {
            return 1;
        }
        return 0;
    }
}

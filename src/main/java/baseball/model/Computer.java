package baseball.model;

import baseball.status.ResultStatus;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Computer {
    // Map<숫자, 야구 공 자리>
    private Map<Integer, Integer> baseballNum;

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int BASEBALL_NUM = 3;

    public Computer() {
        this.generator();
    }

    public BaseballResult compare(Map<Integer, Integer> userBaseballInput) {
        int strikeCount = 0;
        int ballCount = 0;

        for (Integer userNumber : userBaseballInput.keySet()) {
            Integer userPosition = userBaseballInput.get(userNumber);
            ResultStatus result = match(userNumber, userPosition);
            strikeCount += strike(result);
            ballCount += boll(result);
        }
        BaseballResult baseballResult = new BaseballResult(strikeCount, ballCount);
        return baseballResult;
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

    private ResultStatus match(int userNumber, int userPosition) {
        if (!checkContains(userNumber)) {
            return ResultStatus.NOTHING;
        }
        Integer answerPosition = baseballNum.get(userNumber);
        if (answerPosition == userPosition) {
            return ResultStatus.STRIKE;
        }
        return ResultStatus.BALL;
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
        if (result == ResultStatus.BALL) {
            return 1;
        }
        return 0;
    }
}

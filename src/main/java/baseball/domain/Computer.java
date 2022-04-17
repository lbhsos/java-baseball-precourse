package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Computer {
    // Map<number, position>
    private Map<Integer, Integer> baseballNum;

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int BASEBALL_NUM = 3;

    Computer() {
        this.generator();
    }

    private void generator() {
        Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        baseballNum = new HashMap<>();

        for (int seq = 0; seq<BASEBALL_NUM; seq++) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            baseballNum.put(randomNumber, seq);
        }
    }

    boolean compare(Map<Integer, Integer> userBaseballInput) {
        // TODO
        return true;
    }
}

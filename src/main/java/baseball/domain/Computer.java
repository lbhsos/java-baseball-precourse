package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class Computer {
    // Map<positionIndex, number>
    private Map<Integer, Integer> baseballNum;

    Computer() {
        this.generator();
    }

    private void generator() {
        baseballNum = new HashMap<>();
        //TODO
    }

    boolean compare(Map<Integer, Integer> userBaseballInput) {
        // TODO
        return true;
    }
}

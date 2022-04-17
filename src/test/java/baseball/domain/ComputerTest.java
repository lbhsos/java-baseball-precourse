package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ComputerTest {

    private Computer computer = new Computer();
    private OutputStream captor;

    @BeforeEach
    void init() {
        computer = new Computer();
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123, 325"})
    @DisplayName("1볼 1스트라이크를 정상적으로 비교하는지 확인한다")
    void one_boll_one_strike(String givenInput) {
        Map<Integer, Integer> givenUserBaseballNum = stringToMap(givenInput);
        assertRandomNumberInRangeTest(
                () -> {
                    computer = new Computer();
                    boolean answerFlag = computer.compare(givenUserBaseballNum);
                    assertAll(
                            () -> assertThat(answerFlag).isFalse(),
                            () -> assertThat(output()).contains("1볼 1스트라이크")
                    );
                },
                1,3,5
        );
    }

    @Test
    @DisplayName("3스트라이크를 정상적으로 비교하는지 확인한다")
    void all_strike() {
        String givenInput = "135";
        Map<Integer, Integer> givenUserBaseballNum = stringToMap(givenInput);
        assertRandomNumberInRangeTest(
                () -> {
                    computer = new Computer();
                    boolean answerFlag = computer.compare(givenUserBaseballNum);
                    assertAll(
                            () -> assertThat(answerFlag).isTrue(),
                            () -> assertThat(output()).contains("3스트라이크")
                    );
                },
                1,3,5
        );
    }

    @Test
    @DisplayName("낫싱의 경우 정상적으로 비교하는지 확인한다")
    void nothing() {
        String givenInput = "123";
        Map<Integer, Integer> givenUserBaseballNum = stringToMap(givenInput);
        assertRandomNumberInRangeTest(
                () -> {
                    computer = new Computer();
                    boolean answerFlag = computer.compare(givenUserBaseballNum);
                    assertAll(
                            () -> assertThat(answerFlag).isFalse(),
                            () -> assertThat(output()).contains("낫싱")
                    );
                },
                4,5,6
        );
    }

    private Map<Integer, Integer> stringToMap(String numberAsText) {
        Map<Integer, Integer> baseballNum = new HashMap<>();
        for (int i=0; i<3; i++) {
            char c = numberAsText.charAt(i);
            int numericValue = Character.getNumericValue(c);
            baseballNum.put(numericValue, i);
        }
        return baseballNum;
    }

    protected final String output() {
        return captor.toString().trim();
    }
}

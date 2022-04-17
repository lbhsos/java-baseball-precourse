package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballResultTest {

    private BaseballResult givenBaseballResult;

    @Test
    @DisplayName("Baseball 객체의 strikeCount가 3일 때, 정답인지 확인하면 true를 리턴한다.")
    void answer() {
        // given
        int givenStrikeCount = 3;
        int givenBollCount = 0;
        givenBaseballResult = new BaseballResult(givenStrikeCount, givenBollCount);
        // when
        boolean resultAnswer = givenBaseballResult.isAnswer();
        // then
        assertThat(resultAnswer).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    @DisplayName("Baseball 객체의 strikeCount가 3이 아닐 때, 정답인지 확인하면 true를 리턴한다.")
    void not_answer(int givenStrikeCount) {
        // given
        int baseBallCount = 3;
        int givenBollCount = baseBallCount - givenStrikeCount;
        givenBaseballResult = new BaseballResult(givenStrikeCount, givenBollCount);
        // when
        boolean resultAnswer = givenBaseballResult.isAnswer();
        // then
        assertThat(resultAnswer).isEqualTo(false);
    }

    @Test
    @DisplayName("Baseball 객체의 strikeCount와 bollCount가 둘 다 0일 때 결과는 '낫싱'스트링을 리턴한다.")
    void get_result_when_nothing() {
        // given
        int givenStrikeCount = 0;
        int givenBollCount = 0;
        givenBaseballResult = new BaseballResult(givenStrikeCount, givenBollCount);
        // when
        String resultText = givenBaseballResult.getResultText();
        // then
        assertThat(resultText).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("Baseball 객체의 strikeCount가 3이면 결과는 '3스트라이크' 스트링을 리턴한다.")
    void get_result_when_answer() {
        // given
        int givenStrikeCount = 3;
        int givenBollCount = 0;
        givenBaseballResult = new BaseballResult(givenStrikeCount, givenBollCount);
        // when
        String resultText = givenBaseballResult.getResultText();
        // then
        assertThat(resultText).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("Baseball 객체의 givenBollCount가 3이면 결과는 '3볼' 스트링을 리턴한다.")
    void get_result_when_all_boll() {
        // given
        int givenStrikeCount = 0;
        int givenBollCount = 3;
        givenBaseballResult = new BaseballResult(givenStrikeCount, givenBollCount);
        // when
        String resultText = givenBaseballResult.getResultText();
        // then
        assertThat(resultText.trim()).isEqualTo("3볼");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2})
    @DisplayName("결과 호출시 Baseball 객체의 strikeCount와 bollCount 갯수만큼 스트링을 리턴한다.")
    void get_result(int givenStrikeCount) {
        // given
        int baseBallCount = 3;
        int givenBollCount = baseBallCount - givenStrikeCount;
        givenBaseballResult = new BaseballResult(givenStrikeCount, givenBollCount);
        // when
        String resultText = givenBaseballResult.getResultText();
        // then
        assertThat(resultText).isEqualTo(givenBollCount+"볼 "+givenStrikeCount+"스트라이크");
    }

}

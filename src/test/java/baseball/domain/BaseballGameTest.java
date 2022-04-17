package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    private BaseballGame baseballGame;

    @BeforeEach
    void init() {
        baseballGame = new BaseballGame();
    }

    @Test
    @DisplayName("게임 진행 여부 확인 시 사용자가 1을 입력을 하면 true를 반환한다.")
    void continue_game() {
        // given
        // when
        boolean continueGame = baseballGame.checkContinue(1);
        // then
        assertThat(continueGame).isTrue();
    }

    @Test
    @DisplayName("게임 진행 여부 확인 시 사용자가 2을 입력을 하면 false를 반환한다.")
    void stop_game() {
        // given
        // when
        boolean continueGame = baseballGame.checkContinue(2);
        // then
        assertThat(continueGame).isFalse();
    }
}

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
    @DisplayName("게임 정답을 맞춘 후 사용자가 1을 입력을 하면 true를 반환한다.")
    void continue_game() {
        // given
        // when
        boolean continueGame = baseballGame.continueGame(1);
        // then
        assertThat(continueGame).isTrue();
    }
}

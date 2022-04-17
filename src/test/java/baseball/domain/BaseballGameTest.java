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
    @DisplayName("게임이 시작되면 Computer 객체를 리턴한다")
    void start() {
        // given
        // when
        Computer computer = baseballGame.start();
        // then
        assertThat(computer).isNotNull();
    }
}

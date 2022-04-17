package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayInputStream;

import static baseball.view.Message.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void init() {
        player = new Player();
    }

    @ParameterizedTest
    @ValueSource(strings = {"12a", "aaa", "a23"})
    @DisplayName("사용자의 입력이 숫자가 아닌 경우 IllegalArgumentException을 발생시킨다.")
    void throw_with_not_number_input(String givenInput) {
        //given
        command(givenInput);
        // when, then
        assertThatThrownBy(() -> player.getBaseballInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_VALUE_INPUT_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "245678", "23487"})
    @DisplayName("사용자의 입력 문자 길이가 세 글자가 아닌 경우 IllegalArgumentException을 발생시킨다.")
    void throw_with_no_3_length(String givenInput) {
        //given
        command(givenInput);
        // when, then
        assertThatThrownBy(() -> player.getBaseballInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LENGTH_INPUT_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "112", "131"})
    @DisplayName("사용자의 입력 중 숫자 겹칠 경우 IllegalArgumentException을 발생시킨다.")
    void throw_with_no_same_input(String givenInput) {
        //given
        command(givenInput);
        // when, then
        assertThatThrownBy(() -> player.getBaseballInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DIFFERENT_VALUE_REQUIRED_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4", "6", "0"})
    @DisplayName("게임 종료 후 사용자 입력이 1 또는 2가 아닌 경우 IllegalArgumentException을 발생시킨다.")
    void throw_out_of_range_number_for_game_input(String givenInput) {
        //given
        command(givenInput);
        // when, then
        assertThatThrownBy(() -> player.getGameContinueInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_VALUE_GAME_CONTINUE_INPUT_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "*", "^", "!"})
    @DisplayName("게임 종료 후 사용자 입력이 숫자가 아닌 경우 IllegalArgumentException을 발생시킨다.")
    void throw_character_for_game_input(String givenInput) {
        //given
        command(givenInput);
        // when, then
        assertThatThrownBy(() -> player.getGameContinueInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_VALUE_INPUT_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"33", "11", "12"})
    @DisplayName("게임 종료 후 사용자의 입력 문자 길이가 한 글자가 아닌 경우 IllegalArgumentException을 발생시킨다.")
    void throw_with_no_1_length(String givenInput) {
        //given
        command(givenInput);
        // when, then
        assertThatThrownBy(() -> player.getGameContinueInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LENGTH_INPUT_MESSAGE);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}

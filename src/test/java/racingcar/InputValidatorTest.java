package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.InputValidator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @Test
    void 이름_5자_초과() {
        assertThatThrownBy(() -> InputValidator.verifyCarNames(Arrays.asList("banana", "abc")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_중복() {
        assertThatThrownBy(() -> InputValidator.verifyCarNames(Arrays.asList("pobi", "pobi", "jun")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_빈_문자열() {
        String emptyTryCount = "";
        assertThatThrownBy(() -> InputValidator.validateTryCount(emptyTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_음수() {
        String negativeTryCount = "-3";
        assertThatThrownBy(() -> InputValidator.validateTryCount(negativeTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_문자열() {
        String nonNumericTryCount = "abc";
        assertThatThrownBy(() -> InputValidator.validateTryCount(nonNumericTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}


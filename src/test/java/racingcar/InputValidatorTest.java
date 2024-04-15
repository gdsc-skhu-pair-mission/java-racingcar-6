package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.controller.InputValidator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @Test
    void 이름은_5자_이하() {
        assertThatThrownBy(() -> InputValidator.verifyCarNames(Arrays.asList("banana", "abc")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름은_중복될_수_없음() {
        assertThatThrownBy(() -> InputValidator.verifyCarNames(Arrays.asList("pobi", "pobi", "jun")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수는_비워둘_수_없음() {
        String emptyTryCount = "";
        assertThatThrownBy(() -> InputValidator.validateTryCount(emptyTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수는_자연수여야함_() {
        String negativeTryCount = "-3";
        assertThatThrownBy(() -> InputValidator.validateTryCount(negativeTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수는_문자열일_수_없음() {
        String nonNumericTryCount = "abc";
        assertThatThrownBy(() -> InputValidator.validateTryCount(nonNumericTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}


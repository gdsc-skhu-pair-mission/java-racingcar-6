package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.util.InputValidator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {
    @Test
    void 이름은_5자_이하() {
        List<String> carNames = Arrays.asList("banana", "abc");
        Throwable thrown = catchThrowable(() -> InputValidator.verifyCarNames(carNames));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름은_중복될_수_없음() {
        List<String> carNames = Arrays.asList("pobi", "pobi", "jun");
        Throwable thrown = catchThrowable(() -> InputValidator.verifyCarNames(carNames));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수는_비워둘_수_없음() {
        String emptyTryCount = "";
        assertThatThrownBy(() -> InputValidator.validateTryCount(emptyTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수는_자연수_0() {
        String zeroTryCount = "0";
        assertThatThrownBy(() -> InputValidator.validateTryCount(zeroTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수는_자연수_음수() {
        String negativeTryCount = "-3";
        assertThatThrownBy(() -> InputValidator.validateTryCount(negativeTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수는_자연수_소수점() {
        String decimalTryCount = "3.3";
        assertThatThrownBy(() -> InputValidator.validateTryCount(decimalTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수는_문자열일_수_없음() {
        String nonNumericTryCount = "abc123";
        assertThatThrownBy(() -> InputValidator.validateTryCount(nonNumericTryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}


package racingcar.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateInputDataTest {

    @Test
    void 자동차_이름이_중복이면_예외발생() {
        String[] carNames = {"pobi", "pobi"};
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNameDuplicated(carNames));
    }

    @Test
    void 반복_횟수가_정수가_아니면_예외발생() {
        String tryNumber = "abc";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryNumber(tryNumber));
    }

    @Test
    void 반복_횟수를_입력하지_않으면_예외발생() {
        String tryNumber = "";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryNumber(tryNumber));
    }
}
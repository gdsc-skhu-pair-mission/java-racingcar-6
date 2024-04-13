package racingcar.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateInputDataTest {

    @Test
    void 자동차_이름이_중복이면_예외처리() {
        String[] carNames = {"pobi", "pobi"};
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNameDuplicated(carNames));
    }

    @Test
    void 자동차_이름에_공백이_포함되면_예외처리() {
        String carName = "po bi";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarName(carName));
    }

    @Test
    void 자동차_이름_값이_비어있으면_예외처리() {
        String carName = "";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarName(carName));
    }

    @Test
    void 자동차_이름_길이가_6_이상_이면_예외처리() {
        String carName = "whatsgoingon";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarName(carName));
    }

    @Test
    void 반복_횟수가_정수가_아니면_예외처리() {
        String tryNumber = "abc";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryNumber(tryNumber));
    }

    @Test
    void 반복_횟수를_입력하지_않으면_예외처리() {
        String tryNumber = "";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryNumber(tryNumber));
    }
}
package racingcar.util.validator;

import org.junit.jupiter.api.Test;
import racingcar.exception.RacingGameValidationException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TryNumberValidatorTest {

    @Test
    void 반복_횟수_정상인_경우() {
        String tryNumber = "5";
        assertDoesNotThrow(() -> TryNumberValidator.validateTryNumberIsCorrect(tryNumber));
    }

    @Test
    void 반복_횟수_정수형_테스트() {
        String tryNumber = "abc";
        assertThrows(RacingGameValidationException.NotNumericException.class, () -> TryNumberValidator.validateTryNumberIsCorrect(tryNumber));
    }

    @Test
    void 반복_횟수_입력유무_테스트() {
        String tryNumber = "";
        assertThrows(RacingGameValidationException.EmptyInputException.class, () -> TryNumberValidator.validateTryNumberIsCorrect(tryNumber));
    }

    @Test
    void 반복_횟수_자연수가_아닌_경우_테스트() {
        String tryNumber = "-1";
        assertThrows(RacingGameValidationException.NotNaturalNumberException.class, () -> TryNumberValidator.validateTryNumberIsCorrect(tryNumber));

        String tryNumberZero = "0";
        assertThrows(RacingGameValidationException.NotNaturalNumberException.class, () -> TryNumberValidator.validateTryNumberIsCorrect(tryNumberZero));
    }
}

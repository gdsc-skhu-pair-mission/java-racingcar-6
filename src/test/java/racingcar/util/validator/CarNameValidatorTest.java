package racingcar.util.validator;

import org.junit.jupiter.api.Test;
import racingcar.exception.RacingGameValidationException;
import racingcar.util.validator.CarNameValidator;
import racingcar.util.validator.TryNumberValidator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameValidatorTest {


    @Test
    void 유효한_자동차_이름_테스트() {
        String[] carNames = {"pobi", "crong", "honux"};
        assertDoesNotThrow(() -> CarNameValidator.validateCarNameIsCorrect(carNames));
    }

    @Test
    void 자동차_이름_중복_테스트() {
        String[] carNames = {"pobi", "pobi", "HYPE"};
        assertThrows(RacingGameValidationException.DuplicatedCarNameException.class, () -> CarNameValidator.validateCarNameIsCorrect(carNames));
    }

    @Test
    void 자동차_이름_공백_유무_테스트() {
        String[] carNames = {"pobi", " pobi", "BOY"};
        assertThrows(RacingGameValidationException.EmptyInputException.class, () -> CarNameValidator.validateCarNameIsCorrect(carNames));
    }

    @Test
    void 자동차_이름_값_없는경우_테스트() {
        String[] carNames = {"", "", ""};
        assertThrows(RacingGameValidationException.BlankCarNameException.class, () -> CarNameValidator.validateCarNameIsCorrect(carNames));
    }

    @Test
    void 자동차_이름_길이_초과_테스트() {
        String[] carNames = {"pobi", "pobi", "hypeboy"};
        assertThrows(RacingGameValidationException.InvalidNameLengthException.class, () -> CarNameValidator.validateCarNameIsCorrect(carNames));
    }
}

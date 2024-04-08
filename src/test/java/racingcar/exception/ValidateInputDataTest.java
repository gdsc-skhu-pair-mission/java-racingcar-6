package racingcar.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidateInputDataTest {


    @Test
    void 자동차_이름_중복_테스트() {
        String[] carNames = {"pobi", "pobi", "what"};
        assertThrows(IllegalArgumentException.class, () -> ValidateInputData.validateCarNameIsCorrect(carNames));
    }

    @Test
    void 자동차_이름_공백_유무_테스트() {
        String[] carNames = {"pobi", " pobi", "what"};
        assertThrows(IllegalArgumentException.class, () -> ValidateInputData.validateCarNameIsCorrect(carNames));
    }

    @Test
    void 자동차_이름_값_없는경우_테스트() {
        String[] carNames = {"", "", ""};
        assertThrows(IllegalArgumentException.class, () -> ValidateInputData.validateCarNameIsCorrect(carNames));
    }

    @Test
    void 자동차_이름_길이_초과_테스트() {
        String[] carNames = {"pobi", "pobi", "whatsgoingon"};
        assertThrows(IllegalArgumentException.class, () -> ValidateInputData.validateCarNameIsCorrect(carNames));
    }

    @Test
    void 반복_횟수_정수형_테스트() {
        String tryNumber = "abc";
        assertThrows(IllegalArgumentException.class, () -> ValidateInputData.validateTryNumberIsCorrect(tryNumber));
    }

    @Test
    void 반복_횟수_입력유무_테스트() {
        String tryNumber = "";
        assertThrows(IllegalArgumentException.class, () -> ValidateInputData.validateTryNumberIsCorrect(tryNumber));
    }
}
package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.ErrorMessage.INPUT_CAR_NAME_BLANK;
import static racingcar.util.ErrorMessage.INPUT_CAR_NAME_IS_INCORRECT;
import static racingcar.util.ErrorMessage.INPUT_STRING_DUPLICATE;
import static racingcar.util.ErrorMessage.INPUT_STRING_NOT_NULL;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.util.validator.CarValidator;
import racingcar.util.validator.InputValidator;

class CarTest extends NsTest {

    @Test
    @DisplayName("자동차 이름 5글자 이상일 때 예외 처리 테스트")
    void should_ThrowException_When_IsCarNameOverRange() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            CarValidator.checkOverRange("자동차입니다");
        });
        Assertions.assertEquals(INPUT_CAR_NAME_IS_INCORRECT.message, exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 공백일 때 예외 처리 테스트")
    void should_ThrowException_When_IsCarNameEmptyAndBlank() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            CarValidator.checkSpace(" ");
        });
        Assertions.assertEquals(INPUT_CAR_NAME_BLANK.message, exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 null일 때 예외 처리 테스트")
    void should_ThrowException_When_IsCarNameNull() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            InputValidator.checkEmpty(null);
        });
        Assertions.assertEquals(INPUT_STRING_NOT_NULL.message, exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름 겹칠 때 예외 처리 테스트")
    void should_ThrowException_When_IsCarNameDuplicate() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            InputValidator.checkDuplicate("인호,인호");
        });
        Assertions.assertEquals(INPUT_STRING_DUPLICATE.message, exception.getMessage());
    }

    @Test
    @DisplayName("moveCar() 메소드, 인자가 4이상일 경우 전진")
    void should_Move_When_Factor4OrHigher() {
        // given
        Car car = new Car("test");

        // when
        car.setMovement(6);

        // then
        assertThat(car).extracting("movement").isEqualTo(1);
    }

    @Test
    @DisplayName("moveCar() 메소드, 인자가 4미만일 경우 멈춤")
    void should_Stop_When_FactorLessThan4() {
        // given
        Car car = new Car("test");

        // when
        car.setMovement(3);

        // then
        assertThat(car).extracting("movement").isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}

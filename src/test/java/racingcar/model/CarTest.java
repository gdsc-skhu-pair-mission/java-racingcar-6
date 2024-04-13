package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.ErrorMessage.INPUT_CAR_NAME_BLANK;
import static racingcar.util.ErrorMessage.INPUT_CAR_NAME_IS_INCORRECT;
import static racingcar.util.ErrorMessage.INPUT_STRING_DUPLICATE;
import static racingcar.util.ErrorMessage.INPUT_STRING_NOT_NULL;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.util.CarValidator;

public class CarTest extends NsTest {

    @Test
    @DisplayName("차 이름이 5글자 이상일 때 예외가 발생한다.")
    void CAR_NAME_MORE_THAN_5_CHARACTERS_EXCEPTIONS_HANDLING() {
        assertThatThrownBy(() -> CarValidator.checkOverRange("자동차입니다"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_CAR_NAME_IS_INCORRECT.message);
    }

    @Test
    @DisplayName("차 이름에 공백만 들어갔을 때 예외가 발생한다.")
    void CAR_NAME_BLANK_EXCEPTIONS_HANDLING() {
        assertThatThrownBy(() -> CarValidator.checkSpace(" "))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_CAR_NAME_BLANK.message);
    }

    @Test
    @DisplayName("차 이름이 안 들어갔을 때 예외가 발생한다.")
    void CAR_NAME_NULL_EXCEPTIONS_HANDLING() {
        assertThatThrownBy(() -> CarValidator.checkEmpty(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_STRING_NOT_NULL.message);
    }

    @Test
    @DisplayName("차 이름이 겹칠 때 예외가 발생한다.")
    void CAR_NAMES_OVERLAP_EXCEPTIONS_HANDLING() {
        assertThatThrownBy(() -> CarValidator.checkDuplicate("인호,인호"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_STRING_DUPLICATE.message);
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이면 1 전진")
    void CAR_MOVE() {
        // given
        Car car = new Car("test");

        // when
        car.carMove(4);

        // then
        assertThat(car).extracting("move").isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 4 미만이면 멈춤")
    void CAR_STOP() {
        // given
        Car car = new Car("test");

        // when
        car.carMove(3);

        // then
        assertThat(car).extracting("move").isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}

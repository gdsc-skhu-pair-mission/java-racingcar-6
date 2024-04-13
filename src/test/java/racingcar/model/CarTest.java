package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.ErrorMessage.INPUT_CAR_NAME_BLANK;
import static racingcar.util.ErrorMessage.INPUT_CAR_NAME_IS_INCORRECT;
import static racingcar.util.ErrorMessage.INPUT_STRING_DUPLICATE;
import static racingcar.util.ErrorMessage.INPUT_STRING_NOT_NULL;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.util.Validator;

public class CarTest extends NsTest {

    @Test
    void 자동차_이름_5글자_이상일_때() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            Validator.checkOverRange("자동차입니다");
        });
        Assertions.assertEquals(INPUT_CAR_NAME_IS_INCORRECT.message, exception.getMessage());
    }

    @Test
    void 자동차_이름_공백일_때() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            Validator.checkSpace(" ");
        });
        Assertions.assertEquals(INPUT_CAR_NAME_BLANK.message, exception.getMessage());
    }

    @Test
    void 자동차_이름_null일_때() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            Validator.checkEmpty(null);
        });
        Assertions.assertEquals(INPUT_STRING_NOT_NULL.message, exception.getMessage());
    }

    @Test
    void 자동차_이름_겹칠_때() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            Validator.checkDuplicate("인호,인호");
        });
        Assertions.assertEquals(INPUT_STRING_DUPLICATE.message, exception.getMessage());
    }

    @Test
    void 자동차_4_이상_값이면_1_전진() {
        // given
        Car car = new Car("test", 0);

        // when
        car = car.moveCar(6);

        // then
        assertThat(car).extracting("movement").isEqualTo(1);
    }

    @Test
    void 자동차_4_미만_값이면_멈춤() {
        // given
        Car car = new Car("test", 0);

        // when
        car.moveCar(3);

        // then
        assertThat(car).extracting("movement").isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}

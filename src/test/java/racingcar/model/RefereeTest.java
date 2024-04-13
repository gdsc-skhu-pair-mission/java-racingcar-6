package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.ErrorMessage.INPUT_STRING_NOT_NULL;
import static racingcar.util.ErrorMessage.INPUT_WRONG_ROUND_NUMBER;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.util.validator.InputValidator;

public class RefereeTest extends NsTest {
    private final String roundNumber = "3";
    Referee referee = new Referee(roundNumber);

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "1.1", "abc", ""})
    void 라운드_횟수_범위에_맞지_않는_숫자_예외_처리(String input) {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            InputValidator.checkRoundNumber(input);
        });
        Assertions.assertEquals(INPUT_WRONG_ROUND_NUMBER.message, exception.getMessage());
    }

    @Test
    void 라운드_횟수_NULL_예외_처리() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            InputValidator.checkEmpty(null);
        });
        Assertions.assertEquals(INPUT_STRING_NOT_NULL.message, exception.getMessage());
    }

    @Test
    void 우승자_판단() {
        // given (주어진 값)
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("소정", 0));
        cars.add(new Car("인호", 0));
        cars.add(new Car("페어", 0));

        cars.get(0).moveCar(4);
        cars.get(1).moveCar(2);
        cars.get(2).moveCar(1);

        // when (기능 작동)
        List<Car> winnerCars = referee.judgementWinnerCars(cars);

        // then (기능 작동 후 검증)
        assertThat(winnerCars.get(0)).isEqualTo(cars.get(0));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}

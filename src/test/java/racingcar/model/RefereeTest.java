package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.util.ErrorMessage.INPUT_STRING_NOT_NULL;
import static racingcar.util.ErrorMessage.INPUT_WRONG_ROUND_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;
import racingcar.util.RefereeValidator;
import racingcar.util.CarValidator;

public class RefereeTest extends NsTest {
    private final String roundNumber = "3";
    Referee referee = new Referee(roundNumber);

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"0", "-1", "1.1", "abc"})
    @DisplayName("라운드 횟수 범위에 맞지 않는 숫자면 예외가 발생한다.")
    void numberRoundsRangeExceptionHandling(String input) {
        assertThatThrownBy(() -> RefereeValidator.checkRoundNumber(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_WRONG_ROUND_NUMBER.message);
    }

    @Test
    @DisplayName("라운드 횟수 NULL이면 예외가 발생한다.")
    void numberRoundsCountExceptionsHandling() {
        assertThatThrownBy(() -> CarValidator.checkEmpty((String) null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_STRING_NOT_NULL.message);
    }

    @Test
    @DisplayName("우승자 판단")
    void judgmentWinner() {
        // given (주어진 값)
        Cars cars = new Cars(Arrays.asList("소정", "인호", "페어"));

        cars.getCars().get(0).carMove(4);
        cars.getCars().get(1).carMove(2);
        cars.getCars().get(2).carMove(1);

        // when (기능 작동)
        List<Car> winnerCars = referee.judgementWinnerCars(cars);

        // then (기능 작동 후 검증)
        assertThat(winnerCars.get(0)).isEqualTo(cars.getCars().get(0));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}

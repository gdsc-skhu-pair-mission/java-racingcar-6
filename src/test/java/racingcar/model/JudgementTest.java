package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.strategy.AlwaysMoveStrategy;
import racingcar.model.strategy.MoveStrategy;

class JudgementTest {
    private final String testCarName1 = "pobi";
    private final String testCarName2 = "woni";
    private MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        moveStrategy = new AlwaysMoveStrategy();
    }

    @Test
    @DisplayName("단일 우승자")
    void getWinners_Returns_Single_Winner() {
        // given
        Cars cars = Cars.generateCars(List.of(testCarName1));
        cars.moveEligibleCars(moveStrategy);

        // when
        Judgement.getWinners(cars);

        // then
        assertThat(Judgement.getWinners(cars)).isEqualTo(List.of(testCarName1));
    }

    @Test
    @DisplayName("공동 우승자")
    void getWinners_Returns_Multiple_Winners() {
        // given
        Cars cars = Cars.generateCars(List.of(testCarName1, testCarName2));
        cars.moveEligibleCars(moveStrategy);

        // when
        Judgement.getWinners(cars);

        // then
        assertThat(Judgement.getWinners(cars)).isEqualTo(List.of(testCarName1, testCarName2));
    }
}

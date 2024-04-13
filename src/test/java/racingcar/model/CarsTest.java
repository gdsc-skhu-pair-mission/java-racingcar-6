package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.strategy.AlwaysMoveStrategy;
import racingcar.model.strategy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private final String testCarName1 = "pobi";
    private final String testCarName2 = "woni";

    @Test
    @DisplayName("정상적으로 자동차들 객체 생성")
    void generateCars_Correctly_Creates_Car_Objects() {
        // given
        List<String> carNames = List.of(testCarName1, testCarName2);

        // when
        Cars cars = Cars.generateCars(carNames);

        // then
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("자동차들이 규칙에 따라 전진")
    void moveEligibleCars_Applies_Given_Strategy_and_Checks_Positions() {
        // given
        List<String> carNames = List.of(testCarName1, testCarName2);
        Cars cars = Cars.generateCars(carNames);
        MoveStrategy moveStrategy = new AlwaysMoveStrategy();

        // when
        cars.moveEligibleCars(moveStrategy);

        // then
        for (int position : cars.getPositions()) {
            assertThat(position).isEqualTo(1);
        }
    }
}

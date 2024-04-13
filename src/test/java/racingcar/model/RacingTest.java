package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.strategy.AlwaysMoveStrategy;
import racingcar.model.strategy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    private Car testCar1;
    private Car testCar2;
    private MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        testCar1 = new Car("pobi");
        testCar2 = new Car("woni");
        moveStrategy = new AlwaysMoveStrategy();
    }

    @Test
    void 정상적으로_레이싱_객체_생성() {
        // given
        Cars cars = new Cars(List.of(testCar1, testCar2));

        // when
        Racing racing = new Racing(cars, moveStrategy);

        // then
        assertThat(racing).isNotNull();
    }

    @Test
    void 라운드_진행() {
        // given
        Cars cars = new Cars(List.of(testCar1, testCar2));
        Racing racing = new Racing(cars, moveStrategy);

        // when
        racing.start();

        // then
        for (int position : racing.getCars().getPositions()) {
            assertThat(position).isEqualTo(1);
        }
    }

}

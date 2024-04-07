package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Car testCar1;
    private Car testCar2;

    @BeforeEach
    void setUp() {
        testCar1 = new Car("pobi");
        testCar2 = new Car("woni");
    }

    @Test
    void 정상적으로_자동차들_객체_생성() {
        // given
        List<Car> testCars = List.of(testCar1, testCar2);

        // when
        Cars cars = new Cars(testCars);

        // then
        assertThat(cars).isNotNull();
    }

    @Test
    void 자동차들이_규칙에_따라_전진() {
        // given
        List<Car> testCars = List.of(testCar1, testCar2);
        Cars cars = new Cars(testCars);

        // when
        cars.moveEligibleCars(MoveStrategy.ALWAYS_MOVE);

        // then
        for (int position : cars.getPositions()) {
            assertThat(position).isEqualTo(1);
        }
    }

}
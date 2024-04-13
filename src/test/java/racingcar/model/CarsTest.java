package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Cars 객체를 생성합니다.")
    void crateCarsObject() {
        // given
        List<Car> testCars = List.of(testCar1, testCar2);

        // when
        Cars cars = new Cars(testCars);

        // then
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("규칙에 따라 자동차들을 이동시킵니다.")
    void moveCarsAccordingToRule() {
        // given
        List<Car> testCars = List.of(testCar1, testCar2);
        Cars cars = new Cars(testCars);

        // when
        cars.moveEligibleCars(new AlwaysMoveStrategy());

        // then
        for (int position : cars.getPositions()) {
            assertThat(position).isEqualTo(1);
        }
    }

}

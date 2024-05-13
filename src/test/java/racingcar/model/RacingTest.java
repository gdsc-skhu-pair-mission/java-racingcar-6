package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    private Car testCar1;
    private Car testCar2;

    @BeforeEach
    void setUp() {
        testCar1 = new Car("pobi");
        testCar2 = new Car("woni");
    }

    @Test
    @DisplayName("정상적으로 레이싱 객체를 생성합니다.")
    void createRacingObject() {
        // given
        Cars cars = new Cars(List.of(testCar1, testCar2));

        // when
        Racing racing = new Racing(cars, new AlwaysMoveStrategy());

        // then
        assertThat(racing).isNotNull();
    }

    @Test
    @DisplayName("레이싱을 진행합니다.")
    void startRacing() {
        // given
        Cars cars = new Cars(List.of(testCar1, testCar2));
        Racing racing = new Racing(cars, new AlwaysMoveStrategy());

        // when
        racing.start();

        // then
        for (int position : racing.getCars().getPositions()) {
            assertThat(position).isEqualTo(1);
        }
    }

}

package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
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
    void 정상적으로_레이싱_객체_생성() {
        // given
        Cars cars = new Cars(List.of(testCar1, testCar2));

        // when
        Racing racing = new Racing(cars, MoveRule.ALWAYS_MOVE);

        // then
        assertThat(racing).isNotNull();
    }

    @Test
    void 시도_회수만큼_라운드_진행() {
        // given
        Cars cars = new Cars(List.of(testCar1, testCar2));
        Racing racing = new Racing(cars, MoveRule.ALWAYS_MOVE);

        // when
        racing.race(5);

        // then
        for (int position : racing.getCars().getPositions()) {
            assertThat(position).isEqualTo(5);
        }
    }

}
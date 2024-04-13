package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JudgementTest {

    private Car testCar1;
    private Car testCar2;

    @BeforeEach
    void setUp() {
        testCar1 = new Car("pobi");
        testCar2 = new Car("woni");
    }

    @Test
    void 단일_우승자() {
        // given
        testCar1.moveForward();
        Cars cars = new Cars(List.of(testCar1, testCar2));

        // when
        Judgement.getWinners(cars);

        // then
        assertThat(Judgement.getWinners(cars)).isEqualTo(List.of("pobi"));
    }

    @Test
    void 공동_우승자() {
        // given
        Cars cars = new Cars(List.of(testCar1, testCar2));

        // when
        Judgement.getWinners(cars);

        // then
        assertThat(Judgement.getWinners(cars)).isEqualTo(List.of("pobi", "woni"));
    }

}

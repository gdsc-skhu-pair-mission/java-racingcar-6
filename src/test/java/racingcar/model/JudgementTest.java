package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("우승자가 한 명인 경우를 출력합니다.")
    void printSingleWinner() {
        // given
        testCar1.moveForward();
        Cars cars = new Cars(List.of(testCar1, testCar2));

        // when
        Judgement.getWinners(cars);

        // then
        assertThat(Judgement.getWinners(cars)).isEqualTo(List.of("pobi"));
    }

    @Test
    @DisplayName("우승자가 여러 명인 경우를 출력합니다.")
    void printJointWinner() {
        // given
        Cars cars = new Cars(List.of(testCar1, testCar2));

        // when
        Judgement.getWinners(cars);

        // then
        assertThat(Judgement.getWinners(cars)).isEqualTo(List.of("pobi", "woni"));
    }

}

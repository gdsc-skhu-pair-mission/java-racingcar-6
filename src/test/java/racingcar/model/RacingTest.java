package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.strategy.AlwaysMoveStrategy;
import racingcar.model.strategy.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    private final String testCarName1 = "pobi";
    private final String testCarName2 = "woni";
    private MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        moveStrategy = new AlwaysMoveStrategy();
    }

    @Test
    @DisplayName("정상적으로 레이싱 객체 생성")
    void createRacing_Creates_Racing_Object_Correctly() {
        // given
        Cars cars = Cars.generateCars(List.of(testCarName1, testCarName2));

        // when
        Racing racing = new Racing(cars, moveStrategy);

        // then
        assertThat(racing).isNotNull();
    }

    @Test
    @DisplayName("라운드 진행")
    void start_Racing_Rounds_Progress() {
        // given
        Cars cars = Cars.generateCars(List.of(testCarName1, testCarName2));
        Racing racing = new Racing(cars, moveStrategy);

        // when
        racing.start(1);

        // then
        for (int position : racing.getCars().getPositions()) {
            assertThat(position).isEqualTo(1);
        }
    }
}

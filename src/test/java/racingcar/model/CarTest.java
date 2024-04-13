package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 정상적으로_자동차_객체_생성() {
        // given
        String name = "pobi";

        // when
        Car car = new Car(name);

        // then
        assertThat(car).isNotNull();
    }

    @Test
    void 자동차_이름이_5자를_초과하면_예외_발생() {
        // given
        String name = "spiderman";

        // when & then
        assertThatThrownBy(() -> new Car(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_전진() {
        // given
        Car car = new Car("pobi");

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

}

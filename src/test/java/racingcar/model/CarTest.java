package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차 객체를 정상적으로 생성합니다.")
    void createCarObject() {
        // given
        String name = "pobi";

        // when
        Car car = new Car(name);

        // then
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생합니다.")
    void carNameLengthOverFive() {
        // given
        String name = "spiderman";

        // when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백일 경우 예외가 발생합니다.")
    void carNameIsNull() {
        // given
        String name = "   ";

        // when & then
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차가 정상적으로 전진하는지 확인합니다.")
    void carMoveForward() {
        // given
        Car car = new Car("pobi");

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

}

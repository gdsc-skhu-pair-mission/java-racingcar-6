package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("정상적으로 자동차 객체 생성")
    void createCar_Creates_Car_Object_Correctly() {
        // given
        String name = "pobi";

        // when
        Car car = new Car(name);

        // then
        assertThat(car).isNotNull();
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    void createCar_Throws_Exception_If_Car_Name_Exceeds_5_Characters() {
        // given
        String name = "spiderman";

        // when & then
        assertThatThrownBy(() -> new Car(name))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 한 칸 전진")
    void moveForward_Increases_Car_Position_By_One() {
        // given
        Car car = new Car("pobi");

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}

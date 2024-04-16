package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.InputValidator;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void Setup() {
        car = new Car("pobi");
    }

    @Test
    void 차량_생성_테스트() {
        assertEquals("pobi", car.getName());
    }

    @Test
    void 차량_초기값_세팅_테스트() {
        assertEquals(0, car.getDistance());
    }

    @Test
    void 차량_이동_테스트() {
        car.move(true);
        assertEquals(1, car.getDistance());
    }

    @Test
    void 차량_이동거리_표시_테스트_1() {
        car.move(true); // 이동 거리: 1
        car.move(true); // 이동 거리: 2
        assertEquals("--", String.valueOf(car.getMoveAmount()));
    }

    @Test
    void 차량_이동거리_표시_테스트_2() {
        car.move(true); // 이동 거리: 1
        car.move(false); // 이동 거리 : 1
        assertEquals("-", String.valueOf(car.getMoveAmount()));
    }

    @Test
    void 자동차_이름에_공백이_포함되면_예외발생() {
        String carName = "po bi";
        assertThrows(IllegalArgumentException.class, () -> new Car(carName));
    }

    @Test
    void 자동차_이름_값이_비어있으면_예외발생() {
        String carName = "";
        assertThrows(IllegalArgumentException.class, () -> new Car(carName));
    }

    @Test
    void 자동차_이름_길이가_6_이상_이면_예외발생() {
        String carName = "whatsgoingon";
        assertThrows(IllegalArgumentException.class, () -> new Car(carName));
    }

}

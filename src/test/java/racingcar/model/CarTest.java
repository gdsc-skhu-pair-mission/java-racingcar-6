package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    private Car car;

    @BeforeEach
    void Setup() {
        car = new Car("TestCar");
    }

    @Test
    void 차량_생성_테스트() {
        assertEquals("TestCar", car.getName());
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


}

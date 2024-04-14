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
        car.move();
        assertEquals(1, car.getDistance());
    }
}

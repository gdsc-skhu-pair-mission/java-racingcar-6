package racingcar.model;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void testCarMove() {
        Car car = new Car("TestCar");
        assertEquals(0, car.getDistance());
        car.CarMove();
        assertEquals(1, car.getDistance()); // 전진 후 거리 증가 확인
    }
}
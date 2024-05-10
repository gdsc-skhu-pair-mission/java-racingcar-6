package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
        cars.addCar("testCar1");
        cars.addCar("testCar2");
        cars.addCar("testCar3");
    }

    @Test
    void 자동차_입력_테스트() {
        assertEquals(3, cars.getCars().size());
        assertEquals("testCar1", cars.getCars().get(0).getName());
        assertEquals("testCar2", cars.getCars().get(1).getName());
        assertEquals("testCar3", cars.getCars().get(2).getName());
    }

    @Test
    void 우승자가_하나일_때_우승자_찾기() {
        cars.getCars().get(0).move();
        cars.findWinners();
        List<String> winners = cars.getWinners();
        String stringWinners = String.join(", ", winners);
        assertEquals("testCar1", stringWinners);
    }

    @Test
    void 우승자가_다수일때_우승자_찾기() {
        for (Car car : cars.getCars()) {
            car.move();
        }
        cars.findWinners();
        List<String> winners = cars.getWinners();
        String stringWinners = String.join(", ", winners);
        assertEquals("testCar1, testCar2, testCar3", stringWinners);
    }
}

package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
        cars.addCar(new Car("testCar1"));
        cars.addCar(new Car("testCar2"));
        cars.addCar(new Car("testCar3"));
    }

    @Test
    void addCar_test() {
        assertEquals(3, cars.getCars().size());
        assertEquals("testCar1", cars.getCars().get(0).getName());
        assertEquals("testCar2", cars.getCars().get(1).getName());
        assertEquals("testCar3", cars.getCars().get(2).getName());
    }

    @Test
    void 우승자가_하나일_때_우승자_찾기() {
        cars.getCars().get(0).move(true);
        cars.findWinners();
        List<String> winners = cars.getWinners();
        String stringWinners = String.join(", ", winners);
        assertEquals("testCar1", stringWinners);
    }

    @Test
    void 우승자가_여러개일_때_우승자_찾기() {

        cars.getCars().get(0).move(true);
        cars.getCars().get(1).move(true);
        cars.getCars().get(2).move(true);
        cars.findWinners();
        List<String> winners = cars.getWinners();
        String stringWinners = String.join(", ", winners);
        assertEquals("testCar1, testCar2, testCar3", stringWinners);
    }
}

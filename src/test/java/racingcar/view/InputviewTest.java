package racingcar.view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import racingcar.model.Car;

public class InputviewTest {
    @Test
    public void testCarNameInput() {
        Inputview input = new Inputview();
        String carNames = "pobi,crong,honux";
        List<Car> cars = input.CarNameInput(carNames);
        assertEquals(3, cars.size());
        assertEquals("pobi", cars.get(0).getName());
        assertEquals("crong", cars.get(1).getName());
        assertEquals("honux", cars.get(2).getName());
    }
}
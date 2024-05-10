package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.Winner;
import racingcar.model.Car;
import racingcar.controller.RandomNumber;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelTest {
    private Car car1;
    private Car car2;

    @Test
    void 초기_위치_테스트() {
        Car car = new Car("pobi");
        assertEquals(0, car.getPosition());
    }

    @Test
    void 위치_바_테스트() {
        Car car = new Car("pobi");
        car.move();
        assertEquals("-", car.getPositionBar());
    }

    @Test
    void 자동차_객체_생성() {
        assertThat(car1).isNotNull();
        assertThat(car2).isNotNull();
    }

    @Test
    void 우승자_확인() {
        Car car1 = new Car("Car1");
        car1.move();
        Car car2 = new Car("Car2");
        car2.move();
        car2.move(); // car2가 car1보다 두 배 이동한 상태

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        Winner winner = new Winner();
        List<Car> winners = winner.getWinner(carList);

        assertEquals(car2, winners.get(0));
    }

    @Test
    void 랜덤_숫자_생성() {
        int generatedNumber = RandomNumber.generateRandomNumber();
        assertThat(generatedNumber).isBetween(0,9);
    }
}



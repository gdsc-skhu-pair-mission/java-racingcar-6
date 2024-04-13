package racingcar.controller;

import racingcar.model.Car;

import java.util.Collections;
import java.util.List;

public class Winner {
    public List<Car> getWinner(List<Car> carList) {
        int maxPosition = Collections.max(carList.stream().map(Car::getPosition).toList());
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}

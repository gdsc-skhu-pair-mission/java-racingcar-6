package racingcar.model;

import racingcar.model.strategy.MoveStrategy;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars generateCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .toList());
    }

    public void moveEligibleCars(MoveStrategy moveStrategy) {
        cars.stream()
                .filter(car -> moveStrategy.canMove())
                .forEach(Car::moveForward);
    }

    public List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }

    public List<String> getNames() {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

}

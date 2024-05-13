package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public record Cars(List<Car> cars) {

    public static Cars generateCars(List<String> carNames) {
        List<Car> generatedCars = carNames
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(generatedCars);
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

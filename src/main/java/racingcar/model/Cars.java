package racingcar.model;

import racingcar.util.RandomNumberGenerator;

import java.util.List;

public class Cars {

    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveEligibleCars(MoveRule moveRule) {
        for (Car car : cars) {
            if (moveRule.canMove(RandomNumberGenerator.generateRandomNumber(MIN_BOUND, MAX_BOUND))) {
                car.moveForward();
            }
        }
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

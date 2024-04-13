package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.Parser;
import racingcar.util.Validator;

public class Referee {
    private final String roundNumber;
    private final int DEFAULT_MOVEMENT = 0;
    private final int MIN_REQUIRED_CAR_NUMBER = 2;

    public Referee(String roundNumber) {
        Validator.checkEmpty(roundNumber);
        Validator.checkRoundNumber(roundNumber);

        this.roundNumber = roundNumber;
    }

    public int getRoundNumber() {
        return Parser.parseNumber(roundNumber);
    }

    public List<Car> judgementWinnerCars(List<Car> cars) {
        checkLessNumberOfCars(cars);

        int maxMovement = cars.stream()
                .mapToInt(Car::getMovement)
                .max()
                .orElse(DEFAULT_MOVEMENT);

        return cars.stream()
                .filter(car -> car.getMovement() == maxMovement)
                .collect(Collectors.toList());
    }

    private void checkLessNumberOfCars(List<Car> cars) {
        if (cars.size() < MIN_REQUIRED_CAR_NUMBER) {
            throw new IllegalArgumentException("자동차는 최소 2대 이상 필요합니다.");
        }
    }

}

package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.Parser;
import racingcar.util.RefereeValidator;
import racingcar.util.CarValidator;

public class Referee {
    private final String roundNumber;

    public Referee(String roundNumber) {
        CarValidator.checkEmpty(roundNumber);
        RefereeValidator.checkRoundNumber(roundNumber);

        this.roundNumber = roundNumber;
    }

    public int getRoundNumber() {
        return Parser.parseNumber(roundNumber);
    }

    public List<Car> judgementWinnerCars(List<Car> cars) {
        int maxMovement = cars.stream()
                .mapToInt(Car::getMove)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차 목록이 비어 있습니다."));

        return cars.stream()
                .filter(car -> car.getMove() == maxMovement)
                .collect(Collectors.toList());
    }

}

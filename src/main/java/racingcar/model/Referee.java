package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
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
        return Integer.parseInt(roundNumber);
    }

    public List<Car> judgementWinnerCars(Cars cars) {
        int maxMove = cars.getCars().stream()
                .mapToInt(Car::getMove)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차 목록이 비어 있습니다."));

        return cars.getCars().stream()
                .filter(car -> car.getMove() == maxMove)
                .collect(Collectors.toList());
    }
}

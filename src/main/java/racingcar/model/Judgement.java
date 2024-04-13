package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Judgement {

    public static List<String> getWinners(Cars cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.cars()
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition(Cars cars) {
        return cars.cars()
                .stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }

    private Judgement() {
    }

}

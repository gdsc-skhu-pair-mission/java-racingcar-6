package racingcar.model;

import java.util.List;

public class Judgement {

    public static List<String> getWinners(Cars cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.getNames().stream()
                .filter(name -> cars.getPositions().get(cars.getNames().indexOf(name)) == maxPosition)
                .toList();
    }

    private static int getMaxPosition(Cars cars) {
        return cars.getPositions().stream()
                .max(Integer::compareTo)
                .orElseThrow();
    }

}

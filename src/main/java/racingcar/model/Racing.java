package racingcar.model;

import racingcar.dto.CarPositionCapture;
import racingcar.model.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private final List<CarPositionCapture> roundHistories = new ArrayList<>();

    public Racing(Cars cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void start(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveEligibleCars(moveStrategy);

            CarPositionCapture carPositionCapture = new CarPositionCapture(cars.getNames(), cars.getPositions());
            roundHistories.add(carPositionCapture);
        }
    }

    public Cars getCars() {
        return cars;
    }

    public List<CarPositionCapture> getRoundHistories() {
        return roundHistories;
    }

}

package racingcar.model;

import racingcar.model.strategy.MoveStrategy;

public class Racing {

    private final Cars cars;
    private final MoveStrategy moveStrategy;

    public Racing(Cars cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void start() {
        cars.moveEligibleCars(moveStrategy);
    }

    public Cars getCars() {
        return cars;
    }

}

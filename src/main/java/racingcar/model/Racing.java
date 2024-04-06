package racingcar.model;

public class Racing {

    private final Cars cars;
    private final MoveRule moveRule;

    public Racing(Cars cars, MoveRule moveRule) {
        this.cars = cars;
        this.moveRule = moveRule;
    }

    public void start() {
        cars.moveEligibleCars(moveRule);
    }

    public Cars getCars() {
        return cars;
    }

}

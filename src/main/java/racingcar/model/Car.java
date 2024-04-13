package racingcar.model;

import racingcar.util.validator.CarValidator;

public class Car {
    private final int MIN_FORWARD_REQUIREMENT = 4;
    private final int MOVEMENT_DISTANCE = 1;
    private final String NAME;
    private final int POSITION;

    public Car(final String name, final int movement) {
        CarValidator.checkOverRange(name);
        CarValidator.checkSpace(name);

        this.NAME = name;
        this.POSITION = movement;
    }

    public String getName() {
        return NAME;
    }

    public int getMovement() {
        return POSITION;
    }

    public Car moveCar(int number) {
        if (number >= MIN_FORWARD_REQUIREMENT) {
            return new Car(this.NAME, this.POSITION + MOVEMENT_DISTANCE);
        }
        return this;
    }

}

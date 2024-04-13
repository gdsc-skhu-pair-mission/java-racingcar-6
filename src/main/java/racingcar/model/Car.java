package racingcar.model;

import racingcar.exception.InputValidator;

public class Car {
    private String name;
    private int distance;
    private StringBuilder moveAmount;

    public Car(String name) {
        InputValidator.validateCarName(name);
        this.name = name;
        this.distance = 0;
        moveAmount = new StringBuilder();
    }

    public void move(boolean isMove) {
        if (isMove) {
            distance++;
            moveAmount.append("-");
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String getMoveAmount() {
        return moveAmount.toString();
    }
}

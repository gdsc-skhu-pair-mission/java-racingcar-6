package racingcar.model;

import racingcar.exception.ErrorMessage;

public class Car {
    private String name;
    private int distance;
    private StringBuilder moveAmount;

    public Car(String name) {
        validateCarName(name);
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
    public static void validateCarName(String carNames) {
        validateCarNameEmpty(carNames);
        validateCarNameHasBlank(carNames);
        validateCarNameLength(carNames);
    }

    private static void validateCarNameEmpty(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_EMPTY.getMessage());
        }
    }

    private static void validateCarNameHasBlank(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK.getMessage());
        }
    }

    private static void validateCarNameLength(String carName) {
        final int LENGTH_LIMIT_NUMBER = 5;

        if (carName.length() > LENGTH_LIMIT_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
    }

}

package racingcar.model;

public class Car {
    private String name;
    private int distance;
    private StringBuilder moveAmount;

    public Car(String name) {
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

    public StringBuilder getMoveAmount() {
        return moveAmount;
    }
}

package racingcar.model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward() {
        this.position++;
    }

    public String getPositionBar() {
        return "-".repeat(getPosition());
    }
}

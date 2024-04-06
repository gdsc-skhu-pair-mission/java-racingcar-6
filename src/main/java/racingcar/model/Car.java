package racingcar.model;

public class Car {
    private String name;
    private int distance;

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public Car(String carName) {
        this.name = carName;

    }

    RandomValue randomValue = new RandomValue();

    public void CarMove() {
        this.distance++;
    }
}

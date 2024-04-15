package racingcar.model;

import java.util.List;

public class Car {
    private String name;
    private int distance;
    private List<Car> cars;

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public Car(String carName) {
        this.name = carName;
    }

    // 자동차 전진하는 거리를 합산하는 메소드
    public void CarMove() {
        this.distance++;
    }

}

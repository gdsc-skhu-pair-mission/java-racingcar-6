package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Cars {

    private List<Car> cars;
    private static final int FORWARD_NUM = 4;
    private static final int MINIMUM_POSITION = 0;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(String[] carNames) {
        this();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void carForward() {
        for (Car car : cars) {
            if (createRandomNum() >= FORWARD_NUM) {
                car.moveForward();
            }
        }
    }

    public int createRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<String> findWinnerNameFromRacing() {
        int maxPosition = MINIMUM_POSITION;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
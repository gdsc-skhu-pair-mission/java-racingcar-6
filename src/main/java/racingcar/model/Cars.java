package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.CarValidator;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> input) {
        this.cars = new ArrayList<>();
        checkInputCarNames(input);
        addCars(input);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void carsMovement(List<Car> cars) {
        for (Car car : cars) {
            car.carMove(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void checkInputCarNames(List<String> input) {
        CarValidator.checkEmpty(input);
        CarValidator.checkDuplicate(input);
    }

    private void addCars(List<String> names) {
        for (String carName : names) {
            this.cars.add(new Car(carName));
        }
    }

}

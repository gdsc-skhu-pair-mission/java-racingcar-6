package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Inputview {
    public List<Car> CarNameInput() {

        String carName = Console.readLine();
        List<String> carNames = Arrays.stream(carName.split(",")).toList();
        List<Car> cars = new ArrayList<>();
        for(String ca : carNames) {
            Car car = new Car(ca);
            cars.add(car);

        }
        return cars;

    }
    public int countInput(){
        int count = parseInt(Console.readLine());
        return count;
    }
}

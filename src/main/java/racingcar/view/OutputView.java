package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    public static void outputMessage() {
        System.out.println("실행 결과");
    }

    public static void showCar(Cars cars) {
        List<Car> participants = cars.getCars();
        for (Car car : participants) {
            System.out.print(car.getName() + " : ");
            showCarPosition(car);
        }
        System.out.println();
    }

    public static void showCarPosition(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinnerCars(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));

    }
}

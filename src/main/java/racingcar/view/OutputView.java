
package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    public void outputMessage() {
        System.out.println("실행 결과");
    }

    public void showCar(Cars cars) {
        List<Car> participants = cars.getCars();
        StringBuilder sb = new StringBuilder();
        for (Car car : participants) {
            sb.append(car.getName()).append(" : ");
            sb.append(generateCarPosition(car)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public String generateCarPosition(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }


    public void printWinnerCars(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));

    }
}

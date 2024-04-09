package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void resultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void roundResult(List<Car> carList) {
        carList.forEach(car ->
            System.out.println(car.getName() + " : " + car.getPositionBar())
        );
        System.out.println();
    }

    public void finalWinner(List<Car> winnerList) {
        System.out.print("최종 우승자 : ");
        System.out.println(winnerList.stream().map(Car::getName).collect(Collectors.joining(", ")));

    }
}

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
        StringBuilder result = new StringBuilder();
        carList.forEach(car -> result.append(car.getName()).append(" : ").append(car.getPositionBar()).append("\n"));
        System.out.println(result);
    }

    public void finalWinner(List<Car> winnerList) {
        StringBuilder winners = new StringBuilder("최종 우승자 : ");
        String winnerNames = winnerList.stream().map(Car::getName).collect(Collectors.joining(", "));
        winners.append(winnerNames);
        System.out.println(winners);
    }
}

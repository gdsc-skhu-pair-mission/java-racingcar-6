package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private static final int SOLO_WINNER = 1;
    private static final int LAST_COMMA_AND_SPACE = 2;

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printNewline() {
        System.out.println();
    }

    public void printAllCarMovement(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(printEachCarMovement(car));
        }
    }

    public void printWinners(List<Car> winnerCars) {
        StringBuilder nameOfWinnerCars = new StringBuilder();

        if (isSoleWinner(winnerCars)) {
            System.out.println("최종 우승자 : " + nameOfWinnerCars.append(winnerCars.get(0).getName()));
            return;
        }

        for (Car car : winnerCars) {
            nameOfWinnerCars.append(car.getName()).append(", ");
        }

        nameOfWinnerCars.deleteCharAt(nameOfWinnerCars.length() - LAST_COMMA_AND_SPACE);
        System.out.println("최종 우승자 : " + nameOfWinnerCars);
    }

    private String printEachCarMovement(Car car) {
        return car.getName() + " : " + printPosition(car.getMovement());
    }

    private String printPosition(int movementNumber) {
        return "-".repeat(Math.max(0, movementNumber));
    }

    private boolean isSoleWinner(List<Car> winnerCars) {
        return winnerCars.size() == SOLO_WINNER;
    }

}

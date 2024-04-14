package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static OutputView instance;
    private final String RUN_RESULT_MESSAGE = "실행 결과";
    private final String FINNER_WINNER_MESSAGE = "최종 우승자 : ";

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printGameResult() {
        System.out.println(RUN_RESULT_MESSAGE);
    }

    public void printMoveDistance(Car car) {
        System.out.println(car.getName() + " : " + generateDistanceString(car.getDistance()));
    }

    private String generateDistanceString(final int distance) {
        StringBuilder distanceString = new StringBuilder();

        for (int i = 0; i < distance; i++) {
            distanceString.append("-");
        }

        return distanceString.toString();
    }

    public void lineChanging() {
        System.out.println();
    }

    public void printFinalWinner(List<String> finalWinner) {
        System.out.print(FINNER_WINNER_MESSAGE);
        System.out.println(String.join(", ", finalWinner));
    }
}

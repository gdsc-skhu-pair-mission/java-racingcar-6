package racingcar.view;

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

    public void printMoveDistance(String carName, StringBuilder distance) {
        System.out.println(carName + " : " + distance);
    }

    public void lineChanging() {
        System.out.println();
    }

    public void printFinalWinner(List<String> finalWinner) {
        System.out.print(FINNER_WINNER_MESSAGE);
        System.out.println(String.join(", ", finalWinner));
    }
}

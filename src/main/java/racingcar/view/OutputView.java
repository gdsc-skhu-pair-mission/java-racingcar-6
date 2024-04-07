package racingcar.view;

import java.util.List;

public class OutputView {

    private OutputView() {

    }

    public static void printResultHeader() {
        System.out.println("실행 결과");
    }

    public static void printCarPosition(String carName, int position) {
        System.out.print(carName + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

    public static void printNewLine() {
        System.out.println();
    }

}

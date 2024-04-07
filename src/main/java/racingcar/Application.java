package racingcar;

import racingcar.controller.RaceGameController;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceGameController raceGameController = new RaceGameController(new InputView(), new OutputView(), new Winner());
        raceGameController.playRaceGame();
    }
}

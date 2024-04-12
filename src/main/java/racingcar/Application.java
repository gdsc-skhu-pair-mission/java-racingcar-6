package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController = new RacingCarGameController(new InputView(), new OutputView());
        racingCarGameController.start();
    }

}

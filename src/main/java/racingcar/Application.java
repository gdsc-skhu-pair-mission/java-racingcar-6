package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.model.RandomMoveStrategy;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController = new RacingCarGameController(new RandomMoveStrategy());
        racingCarGameController.startGame();
    }
}

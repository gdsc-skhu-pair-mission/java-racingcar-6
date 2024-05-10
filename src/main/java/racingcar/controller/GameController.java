package racingcar.controller;


import racingcar.domain.Cars;
import racingcar.validate.CarNameValidate;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final Cars cars = new Cars();

    public void gameStart() {
        String[] carNames = InputView.inputCarName();
        CarNameValidate.validateCarName(carNames);
        cars.inputCarName(carNames);
        int repeat = InputView.showMoveCount();
        racing(repeat);
        OutputView.printWinnerCars(findWinners());
    }

    public void racing(int repeat) {
        OutputView.outputMessage();
        for (int round = 0; round < repeat; round++) {
            cars.carForward();
            OutputView.showCar(cars);
        }
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }

}

package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.validate.CarNameValidate;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private Cars cars;

    public void gameStart() {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String[] carNames = inputView.inputCarName();
        CarNameValidate.validateCarNamesFromInput(carNames);
        this.cars = new Cars(carNames);
        int repeat = inputView.showMoveCount();
        racing(repeat);
        outputView.printWinnerCars(findWinners());
    }

    public void racing(int repeat) {
        OutputView outputView = new OutputView();

        outputView.outputMessage();
        for (int round = 0; round < repeat; round++) {
            cars.carForward();
            outputView.showCar(cars);
        }
    }

    public List<String> findWinners() {
        return cars.findWinnerNameFromRacing();
    }
}
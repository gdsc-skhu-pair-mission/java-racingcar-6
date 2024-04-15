package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RandomNumber;
import racingcar.model.WinnerChecking;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final WinnerChecking winnerChecking;

    public RaceGameController(InputView inputView, OutputView outputView, WinnerChecking winnerChecking) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.winnerChecking = winnerChecking;
    }

    public void playRaceGame() {
        List<Car> carList = inputView.getCarNameList().stream().map(Car::new).toList();
        int tryCount = inputView.getTryCount();

        outputView.resultMessage();
        while (tryCount -- > 0) {
            carList.forEach(this::playMoveCar);
            outputView.roundResult(carList);
        }

        List<Car> winnerList = winnerChecking.getWinner(carList);
        outputView.finalWinner(winnerList);
    }

    private void playMoveCar(Car car) {
        int randomNumber = RandomNumber.generateRandomNumber();
        if (randomNumber >= Car.MOVE_STANDARD) {
            car.move();
        }
    }
}



package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceGameController {
    public static final int MOVE_STANDARD = 4;
    private final InputView inputView;
    private final OutputView outputView;
    private final Winner winner;

    public RaceGameController(InputView inputView, OutputView outputView, Winner winner) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.winner = winner;
    }

    public void playRaceGame() {
        List<Car> carList = inputView.getCarNameList().stream().map(Car::new).toList();
        int tryCount = inputView.getTryCount();

        outputView.resultMessage();
        for(int i = 0; i < tryCount; i++) {
            carList.forEach(this::playMoveCar);
            outputView.roundResult(carList);
        }

        List<Car> winnerList = winner.getWinner(carList);
        outputView.finalWinner(winnerList);
    }

    public void playMoveCar(Car car) {
        int randomNumber = RandomNumber.generateRandomNumber();
        if (randomNumber >= MOVE_STANDARD) {
            car.move();
        }
    }
}



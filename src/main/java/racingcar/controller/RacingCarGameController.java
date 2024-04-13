package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Referee;
import racingcar.util.Parser;
import racingcar.util.Random;
import racingcar.util.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    private InputView inputView;
    private OutputView outputView;
    private List<Car> cars = new ArrayList<>();

    public RacingCarGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        String inputCarNames = inputView.getCarNames();

        checkInputCarNames(inputCarNames);

        List<String> carNames= Parser.parseStringToList(inputCarNames);

        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }

        Referee referee = new Referee(inputView.getNumberOfRound());

        outputView.printNewline();
        outputView.printResultMessage();

        carsMovementProgress(referee);

        outputView.printWinners(referee.judgementWinnerCars(cars));
    }

    private void checkInputCarNames(String inputCarNames) {
        InputValidator.checkEmpty(inputCarNames);
        InputValidator.checkDuplicate(inputCarNames);
    }

    private void carsMovementProgress(Referee referee) {
        for (int i=0; i < referee.getRoundNumber(); i++) {
            carsMovement(cars);
            outputView.printAllCarMovement(cars);
            outputView.printNewline();
        }
    }

    private void carsMovement(List<Car> cars) {
        for (Car car : cars) {
            cars.set(cars.indexOf(car), car.moveCar(Random.createRandomNumber()));
        }
    }
}

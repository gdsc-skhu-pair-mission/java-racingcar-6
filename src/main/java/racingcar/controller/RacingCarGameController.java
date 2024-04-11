package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Referee;
import racingcar.util.Parser;
import racingcar.util.Random;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    List<Car> cars = new ArrayList<>();

    public void start() {
        String inputCarNames = inputView.getCarNames();

        checkInputCarNames(inputCarNames);

        List<String> carNames= Parser.parseStringToList(inputCarNames);

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        Referee referee = new Referee(inputView.getNumberOfRound());

        outputView.printNewline();
        outputView.printResultMessage();

        carsMovementProgress(referee);

        outputView.printWinners(referee.judgementWinnerCars(cars));
    }

    private void checkInputCarNames(String inputCarNames) {
        Validator.checkEmpty(inputCarNames);
        Validator.checkDuplicate(inputCarNames);
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
            car.setMovement(Random.createRandomNumber());
        }
    }

}

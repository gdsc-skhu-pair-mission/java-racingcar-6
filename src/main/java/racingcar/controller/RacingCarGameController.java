package racingcar.controller;

import racingcar.dto.CarNameDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RacingCarGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void start() {
        String inputCarNames = inputView.getCarNames();

        Cars cars = new Cars(inputCarNamesToList(inputCarNames));

        Referee referee = new Referee(inputView.getNumberOfRound());

        outputView.printNewline();
        outputView.printResultMessage();

        carsMovementProgress(referee, cars);

        printWinningCars(cars, referee);
    }

    private void printWinningCars(Cars cars, Referee referee) {
        List<Car> winnerCarsList = referee.judgementWinnerCars(cars);
        List<CarNameDto> winnerCarNames = convertToCarNameDtos(winnerCarsList);
        outputView.printWinners(winnerCarNames);
    }

    private List<CarNameDto> convertToCarNameDtos(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .map(CarNameDto::of)
                .toList();
    }

    private void carsMovementProgress(Referee referee, Cars carsList) {
        for (int i = 0; i < referee.getRoundNumber(); i++) {
            carsList.carsMovement(carsList.getCars());
            outputView.printAllCarMovement(carsList.getCars());
            outputView.printNewline();
        }
    }

    private List<String> inputCarNamesToList(String input) {
        return Arrays.asList(input.split(","));
    }
}

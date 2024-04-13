package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Judgement;
import racingcar.model.strategy.MoveStrategy;
import racingcar.model.Racing;
import racingcar.model.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    public void startGame() {
        List<String> carNames = getCarNames();
        Cars cars = generateCars(carNames);
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        int tryCount = getTryCount();

        Racing racing = new Racing(cars, moveStrategy);

        OutputView.printResultHeader();
        for (int i = 0; i < tryCount; i++) {
            racing.start();
            printProcess(cars.getNames(), cars.getPositions());
        }

        OutputView.printWinners(Judgement.getWinners(cars));
    }

    private List<String> getCarNames() {
        String carNames = InputView.inputCarNames();
        return splitCarNames(carNames);
    }

    private List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(","));
    }

    private Cars generateCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    private int getTryCount() {
        String inputTryCount = InputView.inputTryCount();

        if (!isNaturalNumberWithZero(inputTryCount)) {
            throw new IllegalArgumentException("시도 횟수는 자연수여야 합니다.");
        }

        return Integer.parseInt(inputTryCount);
    }

    private boolean isNaturalNumberWithZero(String input) {
        if (input.isEmpty() || input.charAt(0) == '0') {
            return false;
        }

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    private void printProcess(List<String> carNames, List<Integer> positions) {
        for (String carName : carNames) {
            int position = positions.get(carNames.indexOf(carName));
            OutputView.printCarPosition(carName, position);
        }
        OutputView.printNewLine();
    }

}

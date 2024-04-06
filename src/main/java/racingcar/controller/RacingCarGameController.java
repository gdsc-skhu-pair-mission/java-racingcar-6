package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.MoveRule;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    public void startGame() {
        List<String> carNames = getCarNames();
        Cars cars = createCars(carNames);

        int tryCount = getTryCount();

        Racing racing = new Racing(cars, MoveRule.RANDOM_4_OR_ABOVE);

        OutputView.printResultHeader();
        for (int i = 0; i < tryCount; i++) {
            racing.start();
            printProcess(cars.getNames(), cars.getPositions());
        }
    }

    private List<String> getCarNames() {
        String carNames = InputView.inputCarNames();
        return splitCarNames(carNames);
    }

    private List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(","));
    }

    private Cars createCars(List<String> carNames) {
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
        for (int i = 0; i < carNames.size(); i++) {
            OutputView.printCarPosition(carNames.get(i), positions.get(i));
        }
        OutputView.printNewLine();
    }
}

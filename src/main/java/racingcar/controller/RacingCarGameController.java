package racingcar.controller;

import java.util.List;
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
        Cars cars = Cars.generateCars(carNames);
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

    private int getTryCount() {
        String inputTryCount = InputView.inputTryCount();

        if (isNotNaturalNumberWithZero(inputTryCount)) {
            throw new IllegalArgumentException("시도 횟수는 자연수여야 합니다.");
        }

        return Integer.parseInt(inputTryCount);
    }

    private boolean isNotNaturalNumberWithZero(String input) {
        if (input.isEmpty() || input.charAt(0) == '0') {
            return true;
        }

        return input.chars()
                .allMatch(Character::isDigit);
    }

    private void printProcess(List<String> carNames, List<Integer> positions) {
        for (String carName : carNames) {
            int position = positions.get(carNames.indexOf(carName));
            OutputView.printCarPosition(carName, position);
        }
        OutputView.printNewLine();
    }

}

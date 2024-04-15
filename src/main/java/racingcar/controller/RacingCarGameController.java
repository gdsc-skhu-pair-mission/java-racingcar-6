package racingcar.controller;

import java.util.List;

import racingcar.dto.CarPositionCapture;
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
        racingStart(racing, tryCount);

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
        if (input.isEmpty()) {
            return true;
        }

        if (input.charAt(0) == '0' && input.length() > 1) {
            return true;
        }

        return !input.chars()
                .allMatch(Character::isDigit);
    }


    private void racingStart(Racing racing, int tryCount) {
        OutputView.printResultHeader();
        racing.start(tryCount);
        printProcess(racing.getRoundHistories());
    }

    private void printProcess(List<CarPositionCapture> roundHistories) {
        for (CarPositionCapture round : roundHistories) {
            List<String> carNames = round.carNames();
            List<Integer> positions = round.positions();

            for (int i = 0; i < carNames.size(); i++) {
                String carName = carNames.get(i);
                int position = positions.get(i);
                OutputView.printCarPosition(carName, position);
            }
            OutputView.printNewLine();
        }
    }

}

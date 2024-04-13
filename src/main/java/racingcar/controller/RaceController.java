package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.MoveDecider;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MoveDecider moveDecider;
    private final Cars cars;

    public RaceController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
        this.moveDecider = new MoveDecider(new RandomNumberGenerator());
        this.cars = Cars.getInstance();
    }

    public void play() {
        addCarsFromInput();
        getAllRounds();
        judgeFinalWinner();
    }

    private void addCarsFromInput() {
        String[] names = inputView.inputRacingCarName();
        for (String name : names) {
            cars.addCar(new Car(name));
        }
    }

    private void getAllRounds() {
        int rounds = inputView.inputAttemptCount();
        outputView.printGameResult();
        for (int i = 0; i < rounds; i++) {
            playRound();
            outputView.lineChanging();
        }
    }

    private void playRound() {
        for (int i = 0; i < cars.getCars().size(); i++) {
            Car car = cars.getCars().get(i);
            car.move(moveDecider.decideMove());
            outputView.printMoveDistance(car.getName(), car.getMoveAmount());
        }
    }

    private void judgeFinalWinner() {
        cars.findWinners();
        outputView.printFinalWinner(cars.getWinners());
    }
}

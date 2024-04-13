package racingcar.model.strategy;

import racingcar.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean canMove() {
        int randomNumber = RandomNumberGenerator.generateRandomNumber(MIN_BOUND, MAX_BOUND);
        return randomNumber >= MOVE_THRESHOLD;
    }

}

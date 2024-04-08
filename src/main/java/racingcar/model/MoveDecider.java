package racingcar.model;

import racingcar.util.NumberGenerator;

public class MoveDecider {

    private static final int MOVING_POINT = 4;
    private final NumberGenerator numberGenerator;

    public MoveDecider(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean decideMove() {
        return getRandomNumber() >= MOVING_POINT;
    }

    private int getRandomNumber() {
        return numberGenerator.generate(0, 9);
    }
}

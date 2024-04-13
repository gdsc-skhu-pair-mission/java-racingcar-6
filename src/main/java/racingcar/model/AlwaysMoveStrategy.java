package racingcar.model;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean canMove() {
        return true;
    }
}

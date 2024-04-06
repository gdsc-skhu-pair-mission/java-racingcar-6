package racingcar.model;

public enum MoveRule {

    RANDOM_4_OR_ABOVE {
        @Override
        public boolean canMove(int randomNumber) {
            return randomNumber >= 4;
        }
    },

    ALWAYS_MOVE {
        @Override
        public boolean canMove(int randomNumber) {
            return true;
        }
    };

    public abstract boolean canMove(int randomNumber);

}

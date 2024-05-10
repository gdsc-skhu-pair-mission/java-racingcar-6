package racingcar.exception;

public class RacingGameValidationException {

    public static class DuplicatedCarNameException extends IllegalArgumentException{
        public DuplicatedCarNameException() {
            super(ErrorMessage.DUPLICATED_CAR_NAME.getMessage());
        }
    }

    public static class BlankCarNameException extends IllegalArgumentException {
        public BlankCarNameException() {
            super(ErrorMessage.NOT_ALLOW_BLANK.getMessage());
        }
    }

    public static class EmptyInputException extends IllegalArgumentException {
        public EmptyInputException() {
            super(ErrorMessage.NOT_ALLOW_EMPTY.getMessage());
        }
    }

    public static class InvalidNameLengthException extends IllegalArgumentException {
        public InvalidNameLengthException() {
            super(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
    }

    public static class NotNumericException extends IllegalArgumentException {
        public NotNumericException() {
            super(ErrorMessage.NOT_NUMERIC.getMessage());
        }
    }

    public static class NotNaturalNumberException extends IllegalArgumentException {
        public NotNaturalNumberException() {
            super(ErrorMessage.ONLY_NATURAL_NUMBER.getMessage());
        }
    }
}

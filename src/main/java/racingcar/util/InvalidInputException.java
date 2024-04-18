package racingcar.util;

public class InvalidInputException {
    private InvalidInputException() {}

    public static class InvalidCarNameLengthException extends IllegalArgumentException {
        public InvalidCarNameLengthException(String message) {
            super(message);
        }
    }

    public static class DuplicateCarNameException extends IllegalArgumentException {
        public DuplicateCarNameException(String message) {
            super(message);
        }
    }

    public static class InvalidTryCountException extends IllegalArgumentException {
        public InvalidTryCountException(String message) {
            super(message);
        }
    }

    public static class InvalidNaturalNumberException extends IllegalArgumentException {
        public InvalidNaturalNumberException(String message) {
            super(message);
        }
    }
}
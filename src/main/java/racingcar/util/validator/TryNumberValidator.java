package racingcar.util.validator;

import racingcar.exception.RacingGameValidationException;

public class TryNumberValidator {

    public static void validateTryNumberIsCorrect(String tryNumber) {
        validateTryNumberIsEmpty(tryNumber);
        validateTryNumberIsNotInt(tryNumber);
        validateTryNumberIsNaturalNumber(tryNumber);
    }

    private static void validateTryNumberIsNotInt(String tryNumber) {
        try {
            Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new RacingGameValidationException.NotNumericException();
        }
    }

    private static void validateTryNumberIsNaturalNumber(String tryNumber) {
        int number = Integer.parseInt(tryNumber);
        if (number <= 0) {
            throw new RacingGameValidationException.NotNaturalNumberException();
        }
    }

    private static void validateTryNumberIsEmpty(String tryNumber) {
        if (tryNumber.isEmpty()) {
            throw new RacingGameValidationException.EmptyInputException();
        }
    }
}

package racingcar.exception;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void validateCarName(String carNames) {
        validateCarNameEmpty(carNames);
        validateCarNameHasBlank(carNames);
        validateCarNameLength(carNames);
    }

    public static void validateCarNameDuplicated(String[] carNames) {
        Set<String> carNameSet = new HashSet<>();
        for (String name : carNames) {
            if (!carNameSet.add(name)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATED_CAR_NAME.getMessage());
            }
        }
    }

    private static void validateCarNameEmpty(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_EMPTY.getMessage());
        }
    }

    private static void validateCarNameHasBlank(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK.getMessage());
        }
    }

    private static void validateCarNameLength(String carName) {
        final int LENGTH_LIMIT_NUMBER = 5;

        if (carName.length() > LENGTH_LIMIT_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
    }


    public static void validateTryNumber(String tryNumber) {
        validateTryNumberIsNotInt(tryNumber);
        validateTryNumberIsNaturalNumber(tryNumber);
        validateTryNumberIsEmpty(tryNumber);
    }

    private static void validateTryNumberIsNotInt(String tryNumber) {
        try {
            Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.getMessage());
        }
    }

    private static void validateTryNumberIsNaturalNumber(String tryNumber) {
        int number = Integer.parseInt(tryNumber);
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NATURAL_NUMBER.getMessage());
        }
    }

    private static void validateTryNumberIsEmpty(String tryNumber) {
        if (tryNumber.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_EMPTY.getMessage());
        }
    }
}

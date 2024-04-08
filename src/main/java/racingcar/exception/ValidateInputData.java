package racingcar.exception;

import java.util.HashSet;
import java.util.Set;

public class ValidateInputData {

    public static void validateCarNameIsCorrect(String[] carNames) {
        validateCarNameEmpty(carNames);
        validateCarNameHasBlank(carNames);
        validateCarNameLength(carNames);
        validateCarNameDuplicated(carNames);
    }

    public static void validateTryNumberIsCorrect(String tryNumber) {
        validateTryNumberIsNotInt(tryNumber);
        validateTryNumberIsNaturalNumber(tryNumber);
        validateTryNumberIsEmpty(tryNumber);
    }

    private static void validateCarNameDuplicated(String[] carNames) {
        Set<String> carNameSet = new HashSet<>();
        for (String name : carNames) {
            if (!carNameSet.add(name)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATED_CAR_NAME.getMessage());
            }
        }
    }

    private static void validateCarNameHasBlank(String[] carNames) {
        for (String name : carNames) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_BLANK.getMessage());
            }
        }
    }

    private static void validateCarNameEmpty(String[] carNames) {
        for (String name : carNames) {
            if (name.contains(" ")) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_EMPTY.getMessage());
            }
        }
    }

    private static void validateCarNameLength(String[] carNames) {
        final int LENGTH_LIMIT_NUMBER = 5;

        for (String name : carNames) {
            if (name.length() > LENGTH_LIMIT_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
            }
        }
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

package racingcar.util.validator;

import racingcar.exception.RacingGameValidationException;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {

    public static void validateCarNameIsCorrect(String[] carNames) {
        validateCarNameHasNoSpace(carNames);
        validateCarNameIsNotBlank(carNames);
        validateCarNameLength(carNames);
        validateCarNameDuplicated(carNames);
    }

    private static void validateCarNameDuplicated(String[] carNames) {
        Set<String> carNameSet = new HashSet<>();
        for (String name : carNames) {
            if (!carNameSet.add(name)) {
                throw new RacingGameValidationException.DuplicatedCarNameException();
            }
        }
    }

    private static void validateCarNameIsNotBlank(String[] carNames) {
        for (String name : carNames) {
            if (name.isEmpty()) {
                throw new RacingGameValidationException.BlankCarNameException();
            }
        }
    }

    private static void validateCarNameHasNoSpace(String[] carNames) {
        for (String name : carNames) {
            if (name.contains(" ")) {
                throw new RacingGameValidationException.EmptyInputException();
            }
        }
    }

    private static void validateCarNameLength(String[] carNames) {
        final int LENGTH_LIMIT_NUMBER = 5;

        for (String name : carNames) {
            if (name.length() > LENGTH_LIMIT_NUMBER) {
                throw new RacingGameValidationException.InvalidNameLengthException();
            }
        }
    }
}

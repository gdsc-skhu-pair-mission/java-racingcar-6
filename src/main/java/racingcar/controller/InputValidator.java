package racingcar.controller;

import java.util.InputMismatchException;
import java.util.List;

public class InputValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void verifyCarNames(List<String> nameList) {
        for (String name : nameList) {
            validateCarNameLength(name);
        }
        validateDuplicateCarName(nameList);
    }

    private static void validateCarNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicateCarName(List<String> nameList) {
        if (nameList.size() > nameList.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

}

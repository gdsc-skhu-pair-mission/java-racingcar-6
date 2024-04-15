package racingcar.util;

import java.util.List;

public class InputValidator {

    private InputValidator() {}
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void verifyCarNames(List<String> nameList) {
        for (String name : nameList) {
            validateCarNameLength(name);
        }
        validateDuplicateCarName(nameList);
    }

    private static void validateCarNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new CarExceptions.InvalidCarNameLengthException("1~5자의 이름을 입력해주세요.");
        }
    }

    private static void validateDuplicateCarName(List<String> nameList) {
        if (nameList.size() > nameList.stream().distinct().count()) {
            throw new CarExceptions.DuplicateCarNameException("중복된 이름입니다.");
        }
    }

    public static void validateTryCount(String tryCount) {
        if (!tryCount.matches("\\d+")) {
            throw new CarExceptions.InvalidTryCountException("자연수를 입력해주세요.");
        }
        int parseTryCount = Integer.parseInt(tryCount);
        if (parseTryCount < 1) {
            throw new CarExceptions.InvalidNaturalNumberException("자연수를 입력해주세요.");
        }
    }
}

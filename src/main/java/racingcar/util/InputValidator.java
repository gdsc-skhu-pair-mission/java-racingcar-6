package racingcar.util;

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
            throw new IllegalArgumentException("1~5자의 이름을 입력해주세요.");
        }
    }

    private static void validateDuplicateCarName(List<String> nameList) {
        if (nameList.size() > nameList.stream().distinct().count()) {
            throw new IllegalArgumentException ("중복된 이름입니다.");
        }
    }

    public static void validateTryCount(String tryCount) {
        if (!tryCount.matches("\\d+")) {
            throw new IllegalArgumentException("자연수를 입력해주세요.");
        }
        int parseTryCount = Integer.parseInt(tryCount);
        validateNaturalNumber(parseTryCount);
    }

    private static void validateNaturalNumber(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("자연수를 입력해주세요.");
        }
    }
}

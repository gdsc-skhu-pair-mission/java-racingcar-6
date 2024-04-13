package racingcar.util.validator;

import static racingcar.util.ErrorMessage.INPUT_CAR_NAME_BLANK;
import static racingcar.util.ErrorMessage.INPUT_CAR_NAME_IS_INCORRECT;

import java.util.regex.Pattern;

public class CarValidator {

    private static final int MAX_DIGIT_CAR_NAME = 5;
    private static final int MIN_DIGIT_CAR_NAME = 1;

    public static void checkOverRange(String input) {
        if (isOverRange(input) || isUnderRange(input)) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_IS_INCORRECT.message);
        }
    }

    public static void checkSpace(String input) {
        if (isSpace(input)) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_BLANK.message);
        }
    }

    private static boolean isOverRange(String input) {
        return MAX_DIGIT_CAR_NAME < input.length();
    }

    private static boolean isUnderRange(String input) {
        return MIN_DIGIT_CAR_NAME > input.length();
    }

    private static boolean isSpace(String input) {
        return Pattern.matches("^\\s+$", input);
    }
}

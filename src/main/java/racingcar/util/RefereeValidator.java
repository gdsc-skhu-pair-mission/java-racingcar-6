package racingcar.util;

import java.util.regex.Pattern;
import static racingcar.util.ErrorMessage.INPUT_WRONG_ROUND_NUMBER;

public class RefereeValidator {

    public static void checkRoundNumber(String input) {
        if (!isRightRoundNumber(input)) {
            throw new IllegalArgumentException(INPUT_WRONG_ROUND_NUMBER.message);
        }
    }
    private static boolean isRightRoundNumber(String input) {
        return Pattern.matches("^[1-9]\\d*$", input);
    }
}

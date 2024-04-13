package racingcar.util.validator;

import static racingcar.util.ErrorMessage.INPUT_STRING_DUPLICATE;
import static racingcar.util.ErrorMessage.INPUT_STRING_NOT_NULL;
import static racingcar.util.ErrorMessage.INPUT_WRONG_ROUND_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.util.Parser;

public class InputValidator {
    public static void checkDuplicate(String input) {
        if (hasDuplicateCarName(input)) {
            throw new IllegalArgumentException(INPUT_STRING_DUPLICATE.message);
        }
    }

    public static void checkEmpty(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_STRING_NOT_NULL.message);
        }
    }

    public static void checkRoundNumber(String input) {
        if (!isRightRoundNumber(input)) {
            throw new IllegalArgumentException(INPUT_WRONG_ROUND_NUMBER.message);
        }
    }

    private static boolean hasDuplicateCarName(String input) {
        List<String> allCarNames = Parser.parseStringToList(input);
        Set set = new HashSet(allCarNames);

        return allCarNames.size() != set.size();
    }

    private static boolean isRightRoundNumber(String input) {
        return Pattern.matches("^[1-9]\\d*$", input);
    }
}

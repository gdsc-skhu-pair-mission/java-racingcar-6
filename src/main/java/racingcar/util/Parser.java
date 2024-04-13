package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public static List<String> parseStringToList(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public static int parseNumber(String input) {
        return Integer.parseInt(input);
    }
}

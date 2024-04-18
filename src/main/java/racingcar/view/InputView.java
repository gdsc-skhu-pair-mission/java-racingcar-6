
package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> getCarNameList() {
        List<String> carNameList;
        while (true) {
            System.out.println(CAR_NAME_INPUT_MESSAGE);
            String input = Console.readLine();
            carNameList = Arrays.asList(input.split(","));
            try {
                InputValidator.verifyCarNames(carNameList);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return carNameList;
    }

    public int getTryCount() {
        int tryCount;
        while (true) {
            System.out.println(TRY_COUNT_INPUT_MESSAGE);
            String input = Console.readLine();
            try {
                InputValidator.validateTryCount(input);
                tryCount = Integer.parseInt(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return tryCount;
    }
}
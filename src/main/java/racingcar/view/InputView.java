package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputValidator;

public class InputView {

    private static InputView instance;
    private final String CAR_NAME_INPUT_PROMPT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String ATTEMPT_PROMPT_MESSAGE = "시도할 회수는 몇 회인가요?";

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String[] inputRacingCarName() {
        System.out.println(CAR_NAME_INPUT_PROMPT_MESSAGE);
        String[] carNames = Console.readLine().split(",");
        InputValidator.validateCarNameDuplicated(carNames);

        return carNames;
    }

    public int inputAttemptCount() {
        System.out.println(ATTEMPT_PROMPT_MESSAGE);
        String tryNumber = Console.readLine();

        InputValidator.validateTryNumber(tryNumber);

        return Integer.parseInt(tryNumber);
    }
}

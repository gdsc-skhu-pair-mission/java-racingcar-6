package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Arrays;


public class Inputview {

    // 자동차 이름 입력받기
    public List<String> carNameInput() {
        String carName = Console.readLine();
        // 입력 받은 자동차 이름을 리스트에 쉼표(,)를 기준으로 잘라서 대입
        return Arrays.asList(carName.split(","));
    }

    // 시도할 횟수 입력 받기
    public String countInput() {
        return Console.readLine();
    }
}



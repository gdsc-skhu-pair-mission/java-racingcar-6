package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;


public class Inputview {
    public List<Car> CarNameInput() {
        // 자동차 이름 입력 받기
        String carName = Console.readLine();
        // 입력 받은 자동차 이름을 리스트에 쉼표(,)를 기준으로 잘라서 대입
        List<String> carNames = Arrays.stream(carName.split(",")).toList();

        // 입력받은 자동차 이름으로 Car 객체 생성해서 객체 리스트에 담기
        List<Car> cars = new ArrayList<>();
        for (String ca : carNames) {
            Car car = new Car(ca);
            cars.add(car);
        }
        // 자동차 이름 중복 검사
        ValidateCarName(carNames);
        // 자동차 객체 리스트 반환
        return cars;
    }

    public int countInput() {
        // 정규 표현식 사용을 위해 String으로 시도할 횟수 입력 받기
        String stringCount = Console.readLine();
        // Int로 시도할 횟수 입력 받기
        int count = Integer.parseInt(stringCount);
        // 시도할 횟수 예외 검사
        ValidateCount(count, stringCount);
        return count;
    }

    // 시도할 횟수를 입력 받을 때 예외처리
    private void ValidateCount(int count, String stringCount) {
        if (count < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1이상이여야 합니다.");
        }
        if (!stringCount.matches("\\d")) {
            // int형 변수.matches("\\d+")
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    // 자동차 이름을 입력 받을 때 예외처리
    private void ValidateCarName(List<String> carNames) {
        for (String correctCarName : carNames) {
            if (correctCarName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        // 자동차 이름 중복 검사를 위해 Set 생성
        Set<String> correctName = new HashSet<>();
        for (String carName : carNames) {
            if (!correctName.add(carName)) {
                throw new IllegalArgumentException("같은 자동차가 입력되었습니다.");
            }
        }
    }
}



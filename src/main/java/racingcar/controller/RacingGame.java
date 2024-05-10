package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.Inputview;
import racingcar.view.Outputview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingGame {
    private final int RANDOM_MIN = 0;
    private final int RANDOM_MAX = 9;
    private final int MOVEABLE_NUMBER = 4;
    private List<Car> cars;
    private Inputview inputview;
    private Outputview outputview;

    public RacingGame(Inputview inputview, Outputview outputview) {
        this.inputview = inputview;
        this.outputview = outputview;
    }

    // 게임 시작 메소드
    public void startGame() {
        outputview.startMessage(); // 게임 시작 안내문 출력
        this.cars = carNameInput();// cars 필드 초기화
    }

    // 유효성 검사를 포함한 자동차 이름 입력받기
    public List<Car> carNameInput() {
        // View를 통해 사용자로부터 입력 받기
        List<String> carNames = inputview.carNameInput();
        // 입력 받은 자동차 이름 유효성 검사
        validateCarName(carNames);

        // 입력받은 자동차 이름으로 Car 객체 생성해서 객체 리스트에 담기
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    // 자동차 이름을 입력 받을 때 예외처리
    private void validateCarName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        // 자동차 이름 중복 검사를 위해 Set 생성
        Set<String> correctName = new HashSet<>(carNames);
        if (correctName.size() < carNames.size()) {
            throw new IllegalArgumentException("같은 자동차가 입력되었습니다.");
        }
    }

    // 시도할 횟수를 입력 받을 때 예외처리
    private int validateCount(String stringCount) {
        if (!stringCount.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        int count = Integer.parseInt(stringCount);
        if (count < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1이상이여야 합니다.");
        }
        return count;
    }

    // 랜덤숫자 생성 메소드
    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }

    // 자동차 이동 메소드
    private void moveCar(Car car) {
        int randomNumber = generateRandomNumber();
        if (randomNumber > MOVEABLE_NUMBER) {
            car.carMove();
        }
        outputview.printMoveResult(car.getName(), car.getDistance());
    }

    // 게임 진행 과정 중 자동차 이동 메소드
    public void carMoving() {
        outputview.countMessage();
        String stringCount = inputview.countInput();
        // 입력 받은 횟수 유효성 검사
        int count = validateCount(stringCount);
        outputview.resultMessage();
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                moveCar(car);
            }
            outputview.printNewLine();
        }
    }

    // 최대거리를 구하는 메소드
    public int maxDistance() {
        // 최대거리 변수 생성 및 0으로 초기화
        int max_distance = 0;
        // 자동차가 움직인 최대거리 구하기
        for (Car car : cars) {
            max_distance = Math.max(max_distance, car.getDistance());
        }
        return max_distance;
    }

    // 우승자 판별
    public List<Car> selectWinner() {

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance()) {
                winners.add(car);
            }
        }
        return winners; // 우승자 리스트 반환
    }

    // 우승자 출력
    public void winner() {
        List<Car> winners = selectWinner();
        outputview.printWinner(winners);
    }
}

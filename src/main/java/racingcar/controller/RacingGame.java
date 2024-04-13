package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.Inputview;
import racingcar.view.Outputview;
import java.util.ArrayList;
import java.util.List;

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
        outputview.startMessage(); //  게임 시작 안내문 출력
        cars = inputview.carNameInput(); // 자동차 이름 입력받기
    }

    // 랜덤숫자 생성 메소드
    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
    }

    // 게임 진행 메소드
    public void gameProcess() {
        outputview.countMessage(); // 게임 진행 횟수 안내문 출력
        int count = inputview.countInput(); // 시도할 횟수 입력받기
        outputview.resultMessage(); // 게임 결과 안내문 출력

        //  각 Car 객체를 이동시키는 로직 구현
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                int randomNumber = generateRandomNumber(); // 랜덤 숫자 생성
                if (randomNumber > MOVEABLE_NUMBER) { // 랜덤 숫자가 4 이상인 경우에 전진
                    car.carMove();
                }
                // 자동차 이동한 거리 출력
                System.out.println(String.format("%s : %s", car.getName(), outputview.moveForward().repeat(car.getDistance())));
            }
            // 게임 횟수 구분하기 위해 개행 추가
            System.out.println("");
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
    public void winner(){
        List<Car> winners = selectWinner();
        outputview.printWinner(winners);
    }

}

package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.Inputview;
import racingcar.view.Outputview;

import java.util.List;
import java.util.Random;

public class RacingGame {
    private List<Car> cars;

    private Inputview inputview;

    private Outputview outputview;

    public RacingGame(Inputview inputview, Outputview outputview) {
        this.inputview = inputview;
        this.outputview = outputview;
    }


    public void StartGame() {
        outputview.StartMessage();
        cars = inputview.CarNameInput();


    }

//    public void GameProcess() {
//        for (int i = 0; i < inputview.countInput(); i++) {
//            // 출력 메소드 인풋만큼 호출
//            // 값 누적
//            게임출력1회();
//        }
//
//    }

    public void 게임출력1회() {

        //  각 Car 객체를 이동시키는 로직 구현

        outputview.CountMessage();
        int count = inputview.countInput();
        outputview.ResultMessage();
        for (int i = 0; i < count; i++) {
            for (Car car : cars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber > 4) {
                    car.CarMove();

                }
                // 자동차 이동한 거리 출력
                System.out.printf("%s : %s\n", car.getName(), outputview.GoMessage().repeat(car.getDistance()));


            }
            // 게임 횟수 구분하기 위해 개행 추가
            System.out.println("");
        }
    }

}
